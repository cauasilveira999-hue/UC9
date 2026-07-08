CREATE TABLE animal (
	id serial primary key,
	nome varchar (200) NOT NULL,
	especie varchar (100) NOT NULL,
	idade int (100) NOT NULL,
	peso numeric (10,2) NOT NULL
);

CREATE TABLE cuidador (
	id serial primary key,
	nome varchar (200) NOT NULL,
	cpf varchar (11) UNIQUE NOT NULL,
	telefone varchar (1O) NOT NULL,
	turno varchar (5) NOT NULL
);

CREATE TABLE recinto (
	id serial primary key,
	nome varchar (200) NOT NULL,
	tipo varchar (100) NOT NULL,
	capacidade int (100) NOT NULL,
	localizacao varchar (100) NOT NULL
)