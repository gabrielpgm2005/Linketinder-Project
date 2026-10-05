CREATE TABLE dados_candidatos (
	id_candidato SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	sobrenome VARCHAR(50) NOT NULL,
	data_de_nascimento DATE NOT NULL,
	email VARCHAR(50) NOT NULL,
	cpf VARCHAR(8) NOT NULL,
	pais VARCHAR(50) NOT NULL,
	cep VARCHAR(8) NOT NULL,
	descricao VARCHAR(100) NOT NULL,
	senha VARCHAR(1000) CHECK (length(senha) >= 6)
);

CREATE TABLE competencias (
	id_competencia SERIAL PRIMARY KEY,
	competencia VARCHAR(50) NOT NULL
);

CREATE TABLE candidatos_competencias (
	id_candidato INTEGER ,
	id_competencia INTEGER,
	FOREIGN KEY (id_candidato) REFERENCES dados_candidatos(id_candidato),
	FOREIGN KEY (id_competencia) REFERENCES competencias(id_competencia)
);

CREATE TABLE dados_empresas (
	id_empresa SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	cnpj VARCHAR(12) NOT NULL,
	email VARCHAR(50) NOT NULL,
	descricao VARCHAR(50) NOT NULL,
	pais VARCHAR(50) NOT NULL,
	cep VARCHAR(50) NOT NULL,
	senha VARCHAR(1000) CHECK (length(senha) >= 6)
);

CREATE TABLE dados_vagas (
	id_vaga SERIAL PRIMARY KEY,
	id_empresa INTEGER REFERENCES dados_empresas(id_empresa),
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(50),
	local VARCHAR(50) NOT NULL	
);

CREATE TABLE vagas_competencias (
	id_vaga INTEGER REFERENCES dados_vagas(id_vaga),
	id_competencia INTEGER REFERENCES competencias(id_competencia)
);


INSERT INTO dados_empresas (nome,cnpj,email,descricao,pais,cep,senha) VALUES 
('Peças Boas','111111','boasPecas@gmail.com','empresa focada em criar boas peças','Brasil','12222','boaVida');

INSERT INTO dados_empresas (nome,cnpj,email,descricao,pais,cep,senha) VALUES 
('Areia Vermelha ltda','32411','areiaVermelha@gmail.com','Fornecemos areia vermelha','Portugal','1243','NossaAreia');

INSERT INTO dados_empresas (nome,cnpj,email,descricao,pais,cep,senha) VALUES 
('Komoney','32533','komoney@gmail.com','empresa focada em destruir o tcg de yugioh','Japão','32445','023945');

INSERT INTO dados_empresas (nome,cnpj,email,descricao,pais,cep,senha) VALUES 
('Caixões Bons','21345','BomCaixao@gmail.com','Criamos bons caixões','Singapura','13243523','hihihAH');

INSERT INTO dados_empresas (nome,cnpj,email,descricao,pais,cep,senha) VALUES 
('Gelo Rapido','34543','geloGelado@gmail.com','os gelos mais gelados do sul','Brasilopolis','3245','geloGwlo');
INSERT INTO dados_candidatos (nome,sobrenome,data_de_nascimento,email,cpf,pais,cep,descricao,senha) VALUES 
('Gabriel','Ribeiro','11-12-2006','GabGabby@gmail.com','324.87','Nepal','134','Dev front end','MusashiGoat');

INSERT INTO dados_candidatos (nome,sobrenome,data_de_nascimento,email,cpf,pais,cep,descricao,senha) VALUES 
('Marcus','Kroll','10-10-1999','marcusKroll@outlook.com','423.32','Singapura','12134','Desenvolvedor Java Champion','CoffeForever');

INSERT INTO dados_candidatos (nome,sobrenome,data_de_nascimento,email,cpf,pais,cep,descricao,senha) VALUES 
('Paulo','Robson','14-03-2010','PRR7@gmail.com','233.87','Japão','5039','Desenvolvedor de jogos','CR7SIUU');

INSERT INTO dados_candidatos (nome,sobrenome,data_de_nascimento,email,cpf,pais,cep,descricao,senha) VALUES 
('Lucas','Rangel','22-07-2008','LucasRangel@gmail.com','982.12','Brasil','123','WEBsec Engenheiro','9u7382t8ewgyi');

INSERT INTO dados_candidatos (nome,sobrenome,data_de_nascimento,email,cpf,pais,cep,descricao,senha) VALUES 
('Aladin','Soberbo','13-10-2018','AladinSOberbin@kimeno.com','212.87','Brasil','0843','Hardware especialist','c++BetterThanSex');
