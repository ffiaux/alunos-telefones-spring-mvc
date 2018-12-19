package com.alunos.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.alunos.spring.model.Aluno;

@Component("alunoDAO")
public class AlunoDAO extends BaseDAO
{
	public Aluno saveOrUpdate(Aluno obj)
	{
		Session s = super.getSession();
		Transaction transObj = s.beginTransaction();
		s.saveOrUpdate(obj);
		transObj.commit();
		s.close();

		return obj;
	}

	public Aluno find(Integer id)
	{
		Session sessionObj = super.getSession();
		Aluno a = sessionObj.find(Aluno.class, id);
		sessionObj.close();

		return a;
	}

	public List<Aluno> findAll()
	{
		Session s = super.getSession();
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Aluno> criteria = builder.createQuery(Aluno.class);
		criteria.from(Aluno.class);
		List<Aluno> alunos = s.createQuery(criteria).getResultList();
		
		return alunos;
	}

	public void delete(Aluno obj)
	{
		Session s = super.getSession();
		Transaction transObj = s.beginTransaction();
		super.getSession().delete(obj);
		transObj.commit();
	}
}