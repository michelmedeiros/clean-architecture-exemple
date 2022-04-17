package br.com.clean.architecture.example.domain.student;

import java.util.List;

public interface StudentRepository {

    Student findByCpf(Cpf cpf);
    Student findByMail(Mail mail);
    Student addRegistration(Student student);
    List<Student> listAll();

}
