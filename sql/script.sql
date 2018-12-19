create database alunos;

create table alunos
(
	id int auto_increment not null,
	nome varchar(20) not null,
	matriculaid int,

	CONSTRAINT PK_Alunos PRIMARY KEY (id)
);

create table telefones
(
	id int auto_increment not null,
	numero varchar(20) not null,
	tipo varchar(20) not null,
	alunoid int not null,

	CONSTRAINT PK_Telefones PRIMARY KEY (id),
	CONSTRAINT FK_Telefones_Alunos FOREIGN KEY (alunoid) REFERENCES alunos (id)
);

create table matriculas
(
	id int auto_increment not null,
	codigo varchar(20) not null,
	dataMatricula datetime not null,
	alunoid int not null,

	CONSTRAINT PK_Matriculas PRIMARY KEY (id),
	CONSTRAINT FK_Matriculas_Alunos FOREIGN KEY (alunoid) REFERENCES alunos (id)
);

create table documentos
(
	id int auto_increment not null,
	tipo varchar(20) not null,
	dataUpload datetime not null,
	alunoid int not null,
	nomePasta varchar(200) not null,
	nomeArquivo varchar(200) not null,

	CONSTRAINT PK_Documentos PRIMARY KEY (id),
	CONSTRAINT FK_Documentos_Alunos FOREIGN KEY (alunoid) REFERENCES alunos (id)
);

alter table alunos add CONSTRAINT FK_Alunos_Matriculas FOREIGN KEY (matriculaid) REFERENCES matriculas (id);