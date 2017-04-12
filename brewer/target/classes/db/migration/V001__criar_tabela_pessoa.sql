CREATE TABLE TipoLogradouro (
  id            int(11) NOT NULL AUTO_INCREMENT, 
  nome          char(80) NOT NULL, 
  CONSTRAINT pk_pais PRIMARY KEY (id));

CREATE TABLE Pais (
  id            int(11) NOT NULL AUTO_INCREMENT, 
  nome          char(80) NOT NULL, 
  fone_codigo   char(4), 
  codigo_bancen int(11), 
  CONSTRAINT pk_pais PRIMARY KEY (id)) comment='Tabela Pais
Contém dados do País.';

CREATE TABLE Estado (
  id            int(11) NOT NULL AUTO_INCREMENT,  
  id_pais       int(11) NOT NULL, 
  nome          char(60), 
  sigla         char(2), 
  codigo_estado int(11), 
  CONSTRAINT pk_estado PRIMARY KEY (id)) comment='Tabela UF
Contém informações da Unidade da Federação (Estado, Provincia, etc.)';

CREATE TABLE Cidade (
  id            int(11) NOT NULL AUTO_INCREMENT, 
  nome          char(60) NOT NULL, 
  id_estado     int(11) NOT NULL, 
  cod_municipio numeric(10, 0) comment 'Código do Municipio

Código do IBGE', 
  fone_area     int(11), 
  latitude      numeric(9, 6), 
  longitude     numeric(9, 6), 
  CONSTRAINT pk_cidade  PRIMARY KEY (id)) comment='Tabela Localidade

Contém os dados de Cidade. Um municipio é uma cidade, mas uma cidade nem sempre é um município.';

ALTER TABLE Estado ADD INDEX fk_estado_pais (id_pais), ADD CONSTRAINT fk_estado_pais FOREIGN KEY (id_pais) REFERENCES Pais (id);
ALTER TABLE Cidade ADD INDEX fk_cidade_estado (id_estado), ADD CONSTRAINT fk_cidade_estado FOREIGN KEY (id_estado) REFERENCES Estado (id);

CREATE TABLE PartidoPolitico (
  id   int(11) NOT NULL AUTO_INCREMENT, 
  nome char(50), 
  PRIMARY KEY (id));
  
CREATE TABLE LogradouroTipo (
  id   int(11) NOT NULL AUTO_INCREMENT, 
  nome char(50) NOT NULL, 
  PRIMARY KEY (id), 
  INDEX (nome));
  
CREATE TABLE Cliente (
  id                    int(15) NOT NULL AUTO_INCREMENT, 
  tipo                  char(1) NOT NULL comment 'Tipo da Cliente
F - Fisica,
J - Juridica', 
  inscricao             numeric(14, 0) comment 'Inscricao

CPF, CNPJ, Outro, conforme tipo da cliente', 
  nome                  char(100) NOT NULL comment 'Nome da Cliente', 
  titulo                char(20) comment 'Título
Título de referência: senhor, senhora, doutor, etc.', 
  apelido               char(50) comment 'Apelido
Nome de apelido ou fantasia', 
  sexo                  char(1) comment 'Sexo
F - Feminino
M - Masculino', 
  estado_civil          char(1), 
  end_tipo_logradouro   int(11) NOT NULL comment 'Tipo do Logradouro', 
  end_logradouro        char(80) comment 'Logradouro', 
  end_numero            int(11) comment 'Número do endereço', 
  end_complemento       char(20) comment 'Complemento do endereço', 
  end_bairro            char(50) comment 'Bairro', 
  end_cidade            int(11) NOT NULL, 
  end_cep               int(11), 
  end_latitude          numeric(9, 6), 
  end_longitude         numeric(9, 6), 
  e_correio             char(80), 
  e_sitio               char(80), 
  cliente_pai            int(15), 
  cliente_mae            int(15), 
  cliente_conjuge        int(15), 
  nasc_data             date, 
  nasc_cidade           int(11), 
  identidade            char(20), 
  identidade_orgao      char(10), 
 
  CONSTRAINT pk_cliente PRIMARY KEY (id), 
  INDEX (inscricao), 
  INDEX (nome), 
  INDEX (apelido)); 
ALTER TABLE Cliente ADD INDEX fk_logradouro_tipo (end_tipo_logradouro), ADD CONSTRAINT fk_logradouro_tipo FOREIGN KEY (end_tipo_logradouro) REFERENCES TipoLogradouro (id);
ALTER TABLE Cliente ADD INDEX fk_end_cidade (end_cidade), ADD CONSTRAINT fk_end_cidade FOREIGN KEY (end_cidade) REFERENCES Cidade (id);
ALTER TABLE Cliente ADD INDEX fk_nasc_cidade (nasc_cidade), ADD CONSTRAINT fk_nasc_cidade FOREIGN KEY (nasc_cidade) REFERENCES Cidade (id) ON UPDATE No action ON DELETE No action;
ALTER TABLE Cliente ADD INDEX fk_partido_politico (partido_politico), ADD CONSTRAINT fk_partido_politico FOREIGN KEY (partido_politico) REFERENCES PartidoPolitico (id);

/* Carga de dados ************************/
insert into TipoLogradouro (id, nome) values (0, 'Alameda');
insert into TipoLogradouro (id, nome) values (0, 'Avenida');
insert into TipoLogradouro (id, nome) values (0, 'Praça');
insert into TipoLogradouro (id, nome) values (0, 'Rua');

insert into Pais (id, nome) values (0, 'Argentina');
insert into Pais (id, nome) values (0, 'Uruguai');
insert into Pais (id, nome) values (0, 'Paraguai');
insert into Pais (id, nome) values (0, 'Angola');
insert into Pais (id, nome) values (0, 'Estados Unidos');
insert into Pais (id, nome) values (0, 'Inglaterra');
insert into Pais (id, nome) values (0, 'Portugal');

insert into Estado (id, id_pais, nome, sigla) values (0, 1, 'Amazonas', 'AM');
insert into Estado (id, id_pais, nome, sigla) values (0, 1, 'Bahia', 'BA');
insert into Estado (id, id_pais, nome, sigla) values (0, 1, 'Minas Gerais', 'MG');
insert into Estado (id, id_pais, nome, sigla) values (0, 1, 'Rio de Janeiro', 'RJ');
insert into Estado (id, id_pais, nome, sigla) values (0, 1, 'Pará', 'PA');

insert into Cidade (id, nome, id_estado) values (0, 'Manaus', 1);
insert into Cidade (id, nome, id_estado) values (0, 'Salvador', 2);
insert into Cidade (id, nome, id_estado) values (0, 'Porto Seguro', 2);
insert into Cidade (id, nome, id_estado) values (0, 'Belo Horizonte', 3);
insert into Cidade (id, nome, id_estado) values (0, 'Betim', 3);
insert into Cidade (id, nome, id_estado) values (0, 'Contagem', 3);
insert into Cidade (id, nome, id_estado) values (0, 'Juiz de Fora', 3);
insert into Cidade (id, nome, id_estado) values (0, 'Montes Claros', 3);
insert into Cidade (id, nome, id_estado) values (0, 'Rio de Janeiro', 4);
insert into Cidade (id, nome, id_estado) values (0, 'Jamapará', 4);
insert into Cidade (id, nome, id_estado) values (0, 'Belém', 5);

