USE master IF EXISTS(select * from sys.databases where name='bd_fitBalance') 
DROP DATABASE bd_fitBalance
GO 
-- CRIAR UM BANCO DE DADOS
CREATE DATABASE bd_fitBalance
GO
-- ACESSAR O BANCO DE DADOS
USE bd_fitBalance
GO

DROP TABLE Usuario
go

CREATE TABLE Usuario
( 
   id            INT			IDENTITY,
   nome          VARCHAR(100)	NOT NULL,
   email         VARCHAR(100)	UNIQUE NOT NULL,
   senha         VARCHAR(100)	NOT NULL,
   nivelAcesso   VARCHAR(10)    NULL, -- ADMIN ou USER
   foto			 VARchar(MAX),
   dataNascimento	 SMALLDATETIME	NOT NULL,
   statusUsuario VARCHAR(20)    NOT NULL, -- ATIVO ou INATIVO ou TROCAR_SENHA

   PRIMARY KEY (id)
)
GO

ALTER TABLE Usuario ADD foto VARchar(max)
ALTER TABLE Usuario ADD dataCadastroUsuario smalldatetime not null DEFAULT getDate()
ALTER TABLE Usuario DROP COLUMN foto

/* Teste */

INSERT Usuario (nome, email, senha, nivelAcesso, foto, dataNascimento, dataCadastroUsuario , statusUsuario)
VALUES ('Eduardo Riberker', 'eduardoriberker@email.com.br', 'MTIzNDU2Nzg=', 'ADMIN', NULL, GETDATE(), GETDATE() , 'ATIVO')
INSERT Usuario (nome, email, senha, nivelAcesso, foto, dataNascimento, dataCadastroUsuario , statusUsuario)
VALUES ('Fulano da Silva', 'fulano@email.com.br', 'MTIzNDU2Nzg=', 'ADMIN', NULL, GETDATE(), GETDATE(), 'ATIVO')
INSERT Usuario (nome, email, senha, nivelAcesso, foto, dataNascimento, dataCadastroUsuario , statusUsuario)
VALUES ('Beltrana de S�', 'beltrana@email.com.br', 'MTIzNDU2Nzg=', 'USER', NULL, GETDATE(), GETDATE(), 'ATIVO')
INSERT Usuario (nome, email, senha, nivelAcesso, foto, dataNascimento, dataCadastroUsuario , statusUsuario)
VALUES ('Sicrana de Oliveira', 'sicrana@email.com.br', 'MTIzNDU2Nzg=', 'USER', NULL, GETDATE(), GETDATE(), 'INATIVO')
INSERT Usuario (nome, email, senha, nivelAcesso, foto, dataNascimento, dataCadastroUsuario , statusUsuario)
VALUES ('Ordnael Zurc', 'ordnael@email.com.br', 'MTIzNDU2Nzg=', 'USER', NULL, GETDATE(), GETDATE(), 'TROCAR_SENHA')
GO


CREATE TABLE Mensagem
(
	id	            INT			  IDENTITY,
	dataMensagem    SMALLDATETIME NOT NULL,
	emissorMensagem VARCHAR(100)  NOT NULL,
	email 	        VARCHAR(100)  NOT NULL,
	telefone	    VARCHAR(20)       NULL,
	texto 	        VARCHAR(400)  NOT NULL,
	statusMensagem  VARCHAR(10)   NOT NULL, -- ATIVO ou INATIVO

	PRIMARY KEY (id)
)
GO
INSERT Mensagem (dataMensagem, emissorMensagem, email, telefone, texto, statusMensagem) 
VALUES (GETDATE(), 'Ordnael Zurc', 'ordnael@email.com', '(11) 98765-4123', 'Mensagem de teste', 'ATIVO')
INSERT Mensagem (dataMensagem, emissorMensagem, email, telefone, texto, statusMensagem) 
VALUES (GETDATE(), 'Maria Onete', 'maria@email.com', null, 'Segunda mensagem de teste', 'ATIVO')
GO

SELECT * FROM Usuario
SELECT * FROM Mensagem
select * from ExerciciosFeito
select * from ExercicioMarcado
select * from Exercicios
SELECT * FROM Arquivo

DELETE FROM Arquivo

 /*Delete from something */

 DELETE FROM Usuario where id >= 5
 DELETE FROM CodigoRecuperacao
 DELETE FROM Exercicios
 DELETE FROM ExercicioMarcado

CREATE TABLE Exercicios(
	id int IDENTITY PRIMARY KEY,
	nivel varchar(25) not null,
	serie int not null,
	repeticoes int not null,
	nome varchar(100) not null ,
	instrucoes varchar(500) not null,
	video VARchar(MAX) ,
	imagem VARchar(MAX)
)
alter table  Exercicios drop column video

alter table Exercicios add video VARCHAR(MAX) 

CREATE TABLE ExercicioFeito(
id int IDENTITY PRIMARY KEY,
usuarioId int references Usuario(id),
exerciciosId int references Exercicios(id) on delete cascade,
data smallDateTime
)

CREATE TABLE ExercicioMarcado(
id int IDENTITY PRIMARY KEY,
usuarioId int references Usuario(id),
exerciciosId int references Exercicios(id) on delete cascade,
)



/*
CREATE TABLE Cardapio
(
	id	            INT			  IDENTITY,
	dataInclusao    SMALLDATETIME NOT NULL,
	obs				VARCHAR(100)	  NULL,
	produto_id		INT			  NOT NULL,
	statusProdCard	VARCHAR(10)	  NOT NULL, -- ATIVO ou INATIVO

	PRIMARY KEY (id),
	FOREIGN KEY (produto_id) REFERENCES Produto (id)
)
GO

CREATE TABLE Categoria
(
	id	 INT		  IDENTITY,
	nome VARCHAR(100) NOT NULL,  -- QUEIJO, FRANGO, CARNES & FRIOS, LEGUMES, DOCES, ESPECIAS, PEIXE

	PRIMARY KEY(id)
)
GO
INSERT Categoria (nome) VALUES ('CARNES & FRIOS')
INSERT Categoria (nome) VALUES ('DOCES')
INSERT Categoria (nome) VALUES ('ESPECIAS')
INSERT Categoria (nome) VALUES ('FRANGO')
INSERT Categoria (nome) VALUES ('LEGUME')
INSERT Categoria (nome) VALUES ('PEIXE')
INSERT Categoria (nome) VALUES ('QUEIJO')
INSERT Categoria (nome) VALUES ('SUCO')
INSERT Categoria (nome) VALUES ('REFRIGERANTE')
GO

CREATE TABLE Produto
(
	id			 INT		    IDENTITY,
	nome	     VARCHAR(100)	NOT NULL,
	descricao	 VARCHAR(400)	NOT NULL,
	codigoBarras VARCHAR(100)	NULL,
	foto		 VARBINARY(max) NULL,
	urlFoto		 VARCHAR(max)	NULL,
	preco		 DECIMAL(8,2)	NOT NULL,
	categoria_id INT			NOT NULL,
	statusProd	 VARCHAR(10)	NOT NULL, -- ATIVO ou INATIVO

	PRIMARY KEY (id),
	FOREIGN KEY (categoria_id) REFERENCES Categoria (id)
)
GO
INSERT Produto (nome, descricao, codigoBarras, foto, urlFoto, preco, categoria_id, statusProd) 
VALUES ('Mu�arela', 'Base de molho de tomate com cobertura de mu�arela, or�gano e tomate', '0001', NULL, 'D:/Imagens/Imagens para Testes/pizza.png', 29.98, 7, 'ATIVO')
INSERT Produto (nome, descricao, codigoBarras, foto, urlFoto, preco, categoria_id, statusProd) 
VALUES ('Calabresa', 'Base de molho de tomate e queijo com cobertura de calabresa', '0002', NULL, NULL, 29.98, 1, 'ATIVO')
INSERT Produto (nome, descricao, codigoBarras, foto, urlFoto, preco, categoria_id, statusProd) 
VALUES ('Frango com Catupiry', 'Base de molho de tomate com cobertura de frango desfiado com catupiry', '0003', NULL, NULL, 37.98, 4, 'ATIVO')
INSERT Produto (nome, descricao, codigoBarras, foto, urlFoto, preco, categoria_id, statusProd) 
VALUES ('Marguerita', 'Base de molho de tomate com cobertura de mu�arela, manjeric�o, or�gano e tomate', '0004', NULL, NULL, 31.98, 7, 'ATIVO')
INSERT Produto (nome, descricao, codigoBarras, foto, urlFoto, preco, categoria_id, statusProd) 
VALUES ('Banana com Canela e Leite Condensado', 'Banana picada coberta com Canela em p� em uma base de Leite Condensado', '0005', NULL, NULL, 35.99, 2, 'ATIVO')
GO

*/
/*
SELECT * FROM Categoria
SELECT * FROM Produto
*/




