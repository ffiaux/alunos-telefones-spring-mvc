package com.alunos.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Alunos")
public class Aluno
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull @NotEmpty
	private String nome;
	
	@OneToMany(mappedBy = "aluno")
	private List<Telefone> telefones;
	
	@OneToMany(mappedBy = "aluno")
	private List<Documento> documentos;
	
	@OneToOne
	@JoinColumn(name = "matriculaid")
	private Matricula matricula;

	public Aluno()
	{
		this.telefones = new ArrayList<>();
		this.documentos = new ArrayList<>();
	}
	
	public List<Documento> getDocumentos()
	{
		return documentos;
	}
	
	public void setDocumentos(List<Documento> documentos)
	{
		this.documentos = documentos;
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

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
}