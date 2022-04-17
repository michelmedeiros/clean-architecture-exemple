create table student
(
    id bigint auto_increment,
    name varchar(100) not null,
    cpf  varchar(20) not null,
    mail  varchar(30) not null,
    password  varchar(30) not null,
    age  int null,
    constraint student_cpf
        unique (cpf)
);

alter table student
    add primary key (id);