create table produto
(
    id int not null AUTO_INCREMENT,
    codigo_produto VARCHAR(255) not null,
    nome_produto VARCHAR(255) not null,
    primary key (id)
);

create table pedido_venda
(
    id int not null AUTO_INCREMENT,
    data_pedido DATE not null,
    primary key (id)
);


create table pedido_venda_item
(
    id_pedido_venda int not null AUTO_INCREMENT,
    id_produto int not null,
    primary key (id_pedido_venda, id_produto),
    foreign key (id_pedido_venda) references pedido_venda (id),
    foreign key (id_produto) references produto (id)
);

insert produto
values (1, 'CAMISA123', 'Camisa Feminina Bolsos Manga Curta'),
       (2, 'CAMISA124', 'Camisa Feminina Jeans Amarração Manga Longa'),
       (3, 'CAMISA125', 'Camisa Feminina Estampada Folhas Sem Manga'),
       (4, 'CAMISA126', 'Camisa Plus Size Feminina Botões Manga Curta'),
       (5, 'CAMISA127', 'Camisa Cropped Feminina Estampa Poá Bolso'),
       (6, 'CAMISA128', 'Camisa Cropped Feminina Sarja Bolsos Zune Jeans'),
       (7, 'CAMISA129', 'Camisa Feminina Botões Nó Manga Longa'),
       (8, 'CAMISA130', 'Camisa Cropped Feminina Sarja Bolsos Botões'),
       (9, 'CAMISA131', 'Camisa Cropped Feminina Sarja Bolsos'),
       (10, 'CAMISA132', 'Camisa Feminina Estampa Folhas Botões Sem Manga');
--       (11, 'CAMISA150', 'Camisa Cropped Feminina Bolso Manga Curta');