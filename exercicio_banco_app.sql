CREATE TABLE cliente (
	id serial primary key,
	nome varchar (200) NOT NULL,
	cpf varchar (11) UNIQUE NOT NULL,
	telefone varchar (10) NOT NULL
	email varchar (100) UNIQUE
);

CREATE TABLE conta (
	id serial primary key,
	numero_conta int (10000000) UNIQUE NOT NULL,
	agencia varchar (200) NOT NULL,
	saldo double NOT NULL,
	tipo_conta varchar (200) NOT NULL
)

CREATE TABLE funcionario (
	id serial primary key,
	nome varchar (200) NOT NULL,
    cargo varchar (100) NOT NULL,
    salario double NOT NULL,
    email varchar (100) UNIQUE NOT NULL
)