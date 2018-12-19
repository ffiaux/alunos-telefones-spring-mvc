package com.alunos.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.alunos.spring.model.Aluno;
import com.alunos.spring.model.Documento;
import com.alunos.spring.model.Matricula;
import com.alunos.spring.model.Telefone;

public abstract class BaseDAO
{
	protected SessionFactory sessionFactory;
	
	public BaseDAO()
	{
		// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");
		configObj.addAnnotatedClass(Aluno.class);
		configObj.addAnnotatedClass(Matricula.class);
		configObj.addAnnotatedClass(Telefone.class);
		configObj.addAnnotatedClass(Documento.class);

		// Since Hibernate Version 4.x, Service Registry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

		// Creating Hibernate Session Factory Instance
		SessionFactory factoryObj = configObj.buildSessionFactory(serviceRegistryObj);

		this.sessionFactory = factoryObj;
	}
	
	public Session getSession()
	{
		return this.sessionFactory.openSession();
	}
}