package com.alunos.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.alunos.spring.model.Documento;

@Component("documentoDAO")
public class DocumentoDAO extends BaseDAO
{
	public Documento saveOrUpdate(Documento obj)
	{
		Session s = super.getSession();
		Transaction transObj = s.beginTransaction();
		s.saveOrUpdate(obj);
		transObj.commit();
		s.close();

		return obj;
	}

	public Documento find(Integer id)
	{
		Session sessionObj = super.getSession();
		Documento a = sessionObj.find(Documento.class, id);
		sessionObj.close();

		return a;
	}

	public List<Documento> findAll()
	{
		Session s = super.getSession();
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Documento> criteria = builder.createQuery(Documento.class);
		criteria.from(Documento.class);
		List<Documento> alunos = s.createQuery(criteria).getResultList();

		return alunos;
	}

	public void delete(Documento obj)
	{
		Session s = super.getSession();
		Transaction transObj = s.beginTransaction();
		super.getSession().delete(obj);
		transObj.commit();
	}
}
