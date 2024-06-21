CREATE DATABASE Mineros
GO
USE Mineros
GO
CREATE TABLE Solicitantes(
	EdadDelPeticionario TINYINT,
	NivelDeEstudios VARCHAR(12),
	NivelDeRenta  VARCHAR(5),
	Patrimonio VARCHAR(5),
	NumeroDeHijos TINYINT,
	TamanoDelCredito INT,
	Funcionario CHAR(2),
	Autorizado CHAR(2)
)
select * from solicitantes
