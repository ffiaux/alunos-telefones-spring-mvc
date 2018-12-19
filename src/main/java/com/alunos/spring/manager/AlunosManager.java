package com.alunos.spring.manager;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alunos.spring.dao.AlunoDAO;
import com.alunos.spring.dao.MatriculaDAO;
import com.alunos.spring.dao.TelefoneDAO;
import com.alunos.spring.model.Aluno;
import com.alunos.spring.model.Matricula;
import com.alunos.spring.model.Telefone;
import com.alunos.spring.util.MatriculaUtil;

@Component("alunosManager")
public class AlunosManager
{
	@Autowired
	private AlunoDAO alunoDAO;
	
	@Autowired
	private MatriculaDAO matriculaDAO;
	
	@Autowired
	private TelefoneDAO telefoneDAO;
	
	public Aluno matricular(Aluno a)
	{
		alunoDAO.saveOrUpdate(a);
		
		for (Telefone tel : a.getTelefones()) {
			tel.setAluno(a);
			telefoneDAO.saveOrUpdate(tel);
		}
		
		Matricula matricula = new Matricula();
		matricula.setAluno(a);
		matricula.setCodigo(MatriculaUtil.gerarMatricula());
		matricula.setDataMatricula(new Date());
		
		matriculaDAO.saveOrUpdate(matricula);
		
		a.setMatricula(matricula);
		alunoDAO.saveOrUpdate(a);
		
		return a;
	}
	
	public List<Aluno> getAlunos()
	{
		return this.alunoDAO.findAll();
	}
}