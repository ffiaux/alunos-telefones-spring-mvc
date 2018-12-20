package com.alunos.spring.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Telefones")
public class Telefone
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull @NotEmpty
	private String numero;

	@Enumerated(EnumType.STRING)
	private TelefoneTipo tipo;

	@ManyToOne
	@JoinColumn(name = "alunoid")
	private Aluno aluno;

	public Telefone()
	{
	}

	public String getNumero()
	{
		return numero;
	}

	public void setNumero(String numero)
	{
		this.numero = numero;
	}

	public TelefoneTipo getTipo()
	{
		return tipo;
	}

	public void setTipo(TelefoneTipo tipo)
	{
		this.tipo = tipo;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
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