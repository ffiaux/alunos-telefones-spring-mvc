package com.alunos.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Matriculas")
public class Matricula
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String codigo;
	private Date dataMatricula;

	@OneToOne
	@JoinColumn(name = "alunoid")
	private Aluno aluno;

	public Matricula()
	{
	}

	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

	public String getCodigo()
	{
		return codigo;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Date getDataMatricula()
	{
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula)
	{
		this.dataMatricula = dataMatricula;
	}

	public Aluno getAluno()
	{
		return aluno;
	}

	public void setAluno(Aluno aluno)
	{
		this.aluno = aluno;
	}
}