create table topico(

    id bigint not null auto_increment,
    titulo varchar (100) not null,
    mensaje varchar(400) not null,
    fechaCreacion varchar(100) not null,
    autor varchar (100) not null,
    curso varchar (100) not null,
    estatus varchar (20) not null,

    primary key(id)
);