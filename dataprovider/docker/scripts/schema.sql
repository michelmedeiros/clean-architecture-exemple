USE  example;
CREATE TABLE IF NOT EXISTS student (
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(255) NOT NULL,
	cpf varchar(20),
    mail varchar(30),
    age int,
    passwd varchar(30),
    CONSTRAINT UC_STUDENT UNIQUE (id,cpf),
    PRIMARY KEY (id)
);

INSERT INTO student(first_name,cpf,mail,age,passwd)
  SELECT 'Michel','998.824.258-00','michel.hotmart@gmail.com',99,'ddj4jj54k3k3l' FROM DUAL
WHERE NOT EXISTS
  (SELECT cpf FROM student WHERE cpf = '998.824.258-00');
