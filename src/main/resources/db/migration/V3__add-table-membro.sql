
create table tbmembro(
    id bigint auto_increment primary key not null,
    nome varchar (100) not null,
    email varchar(100) unique not null,
    senha varchar (20) not null,
    cpf varchar (15) unique not null,
    data_contratacao date not null,
    data_renovacao date not null,
    forma_pagamento varchar(20) not null,
    plano varchar(20) not null
);