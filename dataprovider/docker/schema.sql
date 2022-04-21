CREATE TABLE student (
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(255) NOT NULL,
	cpf varchar(20),
    mail varchar(30),
    age int,
    passwd varchar(30),
    CONSTRAINT UC_STUDENT UNIQUE (id,cpf)
);

ALTER TABLE student
    ADD primary key (id);

INSERT INTO `example`.`student`(`first_name`,`cpf`,`mail`,`age`,`passwd`)
VALUES('Michel','008.873.094-88','michel.tds@gmail.com',43,'ddj4jj54k3k3l');