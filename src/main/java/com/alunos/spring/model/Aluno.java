package com.alunos.spring.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno
{
	private String nome;
	private Matricula matricula;
	private List<Telefone> telefones;
	
	public Aluno()
	{
		this.telefones = new ArrayList<>();
	}
	
	public List<Telefone> getTelefones()
	{
		return telefones;
	}
	
	public void setTelefones(List<Telefone> telefones)
	{
		this.telefones = telefones;
	}
	
	public Matricula getMatricula()
	{
		return matricula;
	}
	
	public void setMatricula(Matricula matricula)
	{
		this.matricula = matricula;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	
}