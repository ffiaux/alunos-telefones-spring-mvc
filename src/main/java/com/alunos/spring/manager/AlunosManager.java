package com.alunos.spring.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alunos.spring.dao.AlunoDAO;
import com.alunos.spring.model.Matricula;

@Component("alunosManager")
public class AlunosManager
{
	@Autowired
	private AlunoDAO alunoDAO;
	
	public Matricula matricular()
	{
		return null;
	}
}