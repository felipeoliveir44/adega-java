create table tbfuncionario(
    id bigint auto_increment primary key not null,
    nome varchar (100) not null,
    email varchar (100) not null unique,
    senha varchar (20) not null,
    telefone varchar (15) not null unique,
    rg varchar (12) not null unique,
    cpf varchar (15) not null unique,
    data_contratacao date not null,
    data_nascimento date not null,
    role varchar (20) not null,
    status tinyint not null
);

create table tbfornecedor(
	id bigint auto_increment primary key not null,
    nome varchar(100) not null,
    email varchar (100) not null unique,
    endereco varchar (100) not null,
    telefone varchar (15)
);

create table tbcliente(
	id bigint auto_increment not null primary key,
    nome varchar (100) not null,
    cpf varchar (15),
    telefone varchar (15)
);
create table tbcategoria (
	id bigint auto_increment not null primary key,
    nome varchar (50) not null
);
create table tbproduto(
	id bigint auto_increment not null primary key,
    nome varchar (50) not null,
    quantidade int not null,
    preco decimal(10,2) not null,
    id_categoria bigint not null,
    foreign key (id_categoria) references tbcategoria(id)
);

create table tbpedido(
    id bigint auto_increment primary key not null,
    id_cliente bigint not null,
    id_produto bigint not null,
    quantidade bigint not null,
    preco_produto decimal(10,2) not null,
    valor_total decimal(10,2) not null,
    foreign key (id_cliente) references tbcliente(id),
    foreign key (id_produto) references tbproduto(id)
);


