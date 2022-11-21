drop table pedido_venda_item;
drop table pedido_venda;
drop table movimento_estoque;
drop table estoque;
drop table empresa;
drop table cliente;
drop table produto;
drop table unidade;


create table unidade
(
    id BIGINT not null AUTO_INCREMENT,
    codigo VARCHAR(255) not null,
    nome VARCHAR(255) not null,
    CONSTRAINT pk_unidade PRIMARY KEY (id)
);

create table produto
(
    id BIGINT not null AUTO_INCREMENT,
    codigo VARCHAR(255) not null,
    nome VARCHAR(255) not null,
    id_unidade BIGINT not null,
    CONSTRAINT pk_produto PRIMARY KEY (id),
    INDEX idx_produto_unidade (id_unidade),
    FOREIGN KEY (id_unidade) references unidade (id)
);

create table cliente
(
    id BIGINT not null AUTO_INCREMENT,
    codigo VARCHAR(255) not null,
    nome VARCHAR(255) not null,
    documento VARCHAR(255) not null,
    tipo_documento VARCHAR(1) not null,
    CONSTRAINT pk_cliente PRIMARY KEY (id)
);

create table empresa
(
    id BIGINT not null AUTO_INCREMENT,
    codigo VARCHAR(255) not null,
    nome VARCHAR(255) not null,
    documento VARCHAR(255) not null,
    tipo_documento VARCHAR(1) not null,
    CONSTRAINT pk_empresa PRIMARY KEY (id)
);

create table estoque
(
    id BIGINT not null AUTO_INCREMENT,
    id_empresa BIGINT not null,
    id_produto BIGINT not null,
    quantidade DECIMAL not null,
    CONSTRAINT pk_estoque PRIMARY KEY (id),
    INDEX idx_estoque_empresa (id_empresa),
    INDEX idx_estoque_produto (id_produto),
    FOREIGN KEY (id_empresa) references empresa (id),
    FOREIGN KEY (id_produto) references produto (id)
);

create table movimento_estoque
(
    id BIGINT not null AUTO_INCREMENT,
    id_estoque BIGINT not null,
    data DATE not null,
    entrada DECIMAL not null,
    saida DECIMAL not null,
    CONSTRAINT pk_movimentoEstoque PRIMARY KEY (id),
    INDEX idx_movimento_estoque_estoque (id_estoque),
    FOREIGN KEY (id_estoque) references estoque (id)
);

create table pedido_venda
(
    id BIGINT not null AUTO_INCREMENT,
    id_cliente BIGINT not null,
    id_empresa BIGINT not null,
    data DATE not null,
    status VARCHAR(1) not null,
    CONSTRAINT pk_pedido_venda PRIMARY KEY (id),
    INDEX idx_pedido_venda_cliente (id_cliente),
    INDEX idx_pedido_venda_empresa (id_empresa),
    FOREIGN KEY (id_cliente) references cliente (id),
    FOREIGN KEY (id_empresa) references empresa (id)
);

create table pedido_venda_item
(
    id BIGINT not null AUTO_INCREMENT,
    id_pedido_venda BIGINT not null,
    id_produto BIGINT not null,
    quantidade DECIMAL not null,
    CONSTRAINT pk_pedido_venda_item PRIMARY KEY (id),
    INDEX idx_pedido_venda_item_pedido_venda (id_pedido_venda),
    INDEX idx_pedido_venda_item_produto (id_produto),
    FOREIGN KEY (id_pedido_venda) references pedido_venda (id),
    FOREIGN KEY (id_produto) references produto (id)
);


insert cliente
values (1, 'CLI1', 'PARIS MODAS', '123456789', 'J');

insert empresa
values (1, 'CLI1', 'CERES ANTUN MODAS', '987654321', 'J');

insert unidade
values (1, 'PC', 'PEÇA');


insert produto
values (1, 'CAMISA123', 'Camisa Feminina Bolsos Manga Curta', 1),
       (2, 'CAMISA124', 'Camisa Feminina Jeans Amarração Manga Longa', 1),
       (3, 'CAMISA125', 'Camisa Feminina Estampada Folhas Sem Manga', 1),
       (4, 'CAMISA126', 'Camisa Plus Size Feminina Botões Manga Curta', 1),
       (5, 'CAMISA127', 'Camisa Cropped Feminina Estampa Poá Bolso', 1),
       (6, 'CAMISA128', 'Camisa Cropped Feminina Sarja Bolsos Zune Jeans', 1),
       (7, 'CAMISA129', 'Camisa Feminina Botões Nó Manga Longa', 1),
       (8, 'CAMISA130', 'Camisa Cropped Feminina Sarja Bolsos Botões', 1),
       (9, 'CAMISA131', 'Camisa Cropped Feminina Sarja Bolsos', 1),
       (10, 'CAMISA132', 'Camisa Feminina Estampa Folhas Botões Sem Manga', 1);
--       (11, 'CAMISA150', 'Camisa Cropped Feminina Bolso Manga Curta', 1);


