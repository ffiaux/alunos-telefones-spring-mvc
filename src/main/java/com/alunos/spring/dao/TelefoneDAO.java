package com.alunos.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.alunos.spring.model.Telefone;

@Component("telefoneDAO")
public class TelefoneDAO extends BaseDAO{
	public Telefone saveOrUpdate(Telefone obj)
	{
		Session s = super.getSession();
		Transaction transObj = s.beginTransaction();
		s.saveOrUpdate(obj);
		transObj.commit();
		s.close();

		return obj;
	}

	public Telefone find(Integer id)
	{
		Session sessionObj = super.getSession();
		Telefone a = sessionObj.find(Telefone.class, id);
		sessionObj.close();

		return a;
	}

	public List<Telefone> findAll()
	{
		Session s = super.getSession();
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Telefone> criteria = builder.createQuery(Telefone.class);
		criteria.from(Telefone.class);
		List<Telefone> telefones = s.createQuery(criteria).getResultList();
		
		return telefones;
	}

	public void delete(Telefone obj)
	{
		Session s = super.getSession();
		Transaction transObj = s.beginTransaction();
		super.getSession().delete(obj);
		transObj.commit();
	}
}