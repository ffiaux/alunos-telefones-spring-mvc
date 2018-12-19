package com.alunos.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Documentos")
public class Documento
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "alunoid")
	private Aluno aluno;
	
	@Enumerated(EnumType.STRING)
	private DocumentoTipo tipo;
	private Date dataUpload;
	private String nomePasta;
	private String nomeArquivo;

	public Documento()
	{
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

	public DocumentoTipo getTipo()
	{
		return tipo;
	}

	public void setTipo(DocumentoTipo tipo)
	{
		this.tipo = tipo;
	}

	public Date getDataUpload()
	{
		return dataUpload;
	}

	public void setDataUpload(Date dataUpload)
	{
		this.dataUpload = dataUpload;
	}

	public String getNomePasta()
	{
		return nomePasta;
	}

	public void setNomePasta(String nomePasta)
	{
		this.nomePasta = nomePasta;
	}

	public String getNomeArquivo()
	{
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo)
	{
		this.nomeArquivo = nomeArquivo;
	}
}