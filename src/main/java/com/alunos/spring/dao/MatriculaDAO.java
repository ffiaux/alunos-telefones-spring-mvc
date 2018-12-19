package com.alunos.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.alunos.spring.model.Matricula;

@Component("matriculaDAO")
public class MatriculaDAO extends BaseDAO{

	public Matricula saveOrUpdate(Matricula obj)
	{
		Session s = super.getSession();
		Transaction transObj = s.beginTransaction();
		s.saveOrUpdate(obj);
		transObj.commit();
		s.close();

		return obj;
	}

	public Matricula find(Integer id)
	{
		Session sessionObj = super.getSession();
		Matricula a = sessionObj.find(Matricula.class, id);
		sessionObj.close();

		return a;
	}

	
	public List<Matricula> findAll()
	{
		Session s = super.getSession();
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Matricula> criteria = builder.createQuery(Matricula.class);
		criteria.from(Matricula.class);
		List<Matricula> matriculas = s.createQuery(criteria).getResultList();
		
		return matriculas;
	}

	
	public void delete(Matricula obj)
	{
		Session s = super.getSession();
		Transaction transObj = s.beginTransaction();
		super.getSession().delete(obj);
		transObj.commit();
	}
}