CREATE DATABASE empresa;

create table funcionarios (
	id serial primary key,
	nome varchar(100),
	cargo varchar(80),
	salario numeric(10,2),
	idade int,
	cidade varchar(80),
	ativo boolean
)

create table produtos (
	id serial primary key,
	nome varchar(100),
	categoria varchar(80),
	preco numeric(10,2),
	estoque int
)

create table pedidos (
	id serial primary key,
	cliente varchar(100),
	produto varchar(100),
	quantidade int,
	valor_total numeric(10,2),
	data_pedido date
	
)

INSERT INTO funcionarios (id, nome, cargo, salario, idade, cidade, ativo) 
VALUES
(100, 'Rodrigo', 'Gerente', 5235, 27, 'Alvorada', true),
(101, 'Luisa', 'Tecnica', 2200, 21, 'Curitiba', true),
(102, 'Daniel', 'Faxineiro', 1650, 66, 'Canoas', true),
(103, 'Maria', 'Auxiliar Tecnica', 2000, 25, 'São Leopoldo', true),
(104, 'Pablo', 'Tecnico', 2235, 28, 'Canoas', true),
(105, 'Bruno', 'Recepção', 1650, 33, 'Sapucaia do Sul', true),
(106, 'Homer', 'Auxiliar Tecnico', 2000, 27, 'Alvorada', true),
(107, 'Yago', 'Faxineiro', 1235, 17, 'São Leopoldo', true),
(108, 'Victoria', 'Programadora', 5500, 24, 'Sapucaia do Sul', true),
(109, 'Lucas', 'Tecnico', 2200, 29, 'Porto Alegre', true),

INSERT INTO produtos (id, nome, categoria, preco, estoque) 
VALUES
(100, 'Celular', 'Eletronicos', 5000.00, 100),
(101, 'Vassoura', 'Objetos', 25.00, 200),
(102, 'GTA 6', 'Jogos', 550.00, 5000),
(103, 'Mouse', 'Eletronicos', 159.00, 150),
(104, 'Balcão', 'Decoração', 1600.99, 409),
(105, 'Livro', 'Livros', 65.00, 1500),
(106, 'Carrinho', 'Brinquedos', 20.00, 150),
(107, 'Caderno', 'Material Escolar', 25.00, 378),
(108, 'Carregador', 'Eletronicos', 39.90, 150),
(109, 'Cadeira', 'Decoração', 80.00, 430)

INSERT INTO pedidos (id, cliente, produto, quantidade, valor_total, data_pedido) 
VALUES
(100, 'Rosalinda', 'Vassoura', 1, 25.00, 10-07-2026),
(101, 'Rogerio', 'Celular', 1, 5000.00, 07-22-2026),
(102, 'Tiberio', 'GTA 6', 1, 550.00, 08-06-2026),
(103, 'Walter', 'Mouse', 1, 159.00, 07-21-2026),
(104, 'Camila', 'Cadeira', 1, 80.00, 12-22-2026),
(105, 'Vitor', 'Carregador', 1, 39.90, 09-09-2026),
(106, 'Beatriz', 'Livro', 1, 65.00, 12-10-2026),
(107, 'Italo', 'Balcão', 1, 1600.99, 12/11),
(108, 'Carlos', 'Caderno', 1, 25.00, 04/10),
(109, 'Helena', 'Carrinho', 1, 20.00, 06/07)

SELECT *
FROM funcionarios;

SELECT *
FROM produtos;

SELECT *
FROM pedidos;

SELECT nome,
FROM funcionarios;

SELECT nome, cargo,
FROM funcionarios;

SELECT nome, salario,
FROM funcionarios;
where salario > 3.000;

SELECT *
FROM funcionarios;
where idade > 30;

SELECT *
FROM funcionarios;
where ativos = true;

SELECT *
FROM funcionarios;
where ativos = false;

SELECT *
FROM produtos;
where preco > 500.00;

SELECT *
FROM produtos;
where preco < 100.00;

SELECT *
FROM produtos;
where estoque > 20;

SELECT *
FROM pedidos;
where valor_total > 500.00;

SELECT * FROM pedidos 
WHERE valor_total BETWEEN 200.00 AND 800.00;

SELECT *
FROM funcionarios;
where cidade = 'Porto Alegre';

SELECT * FROM funcionarios 
WHERE cidade IN ('Porto Alegre', 'Canoas');

SELECT * FROM funcionarios 
WHERE idade BETWEEN 20 AND 40;

SELECT * FROM funcionarios 
WHERE nome LIKE 'M%';

SELECT * FROM funcionarios 
WHERE nome LIKE 'M%';

SELECT * FROM funcionarios 
WHERE nome LIKE '%A';

SELECT * FROM produtos 
WHERE nome_produto LIKE '%mouse%';

SELECT *
FROM funcionarios;
where idade > 25 AND ativos = true;

SELECT * FROM funcionarios 
WHERE cidade = 'Canoas' OR cidade = 'Novo Hamburgo';

SELECT * FROM funcionarios 
WHERE NOT ativo;

SELECT * FROM produtos 
ORDER BY preco ASC;

SELECT * FROM produtos 
ORDER BY preco DESC;

SELECT * FROM funcionarios 
ORDER BY nome ASC;

SELECT * FROM produtos 
LIMIT 5;

SELECT * FROM funcionarios 
LIMIT 3;

SELECT * FROM produtos 
WHERE categoria IN ('Informática', 'Escritório');