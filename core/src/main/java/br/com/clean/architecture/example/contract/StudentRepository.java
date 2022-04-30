package br.com.clean.architecture.example.contract;

import br.com.clean.architecture.example.domain.Student;
import br.com.clean.architecture.example.vo.Cpf;
import br.com.clean.architecture.example.vo.Mail;

import java.util.List;

public interface StudentRepository {
    Student findByCpf(Cpf cpf);
    Student findByMail(Mail mail);
    Student addRegistration(Student student);
    List<Student> listAll();
}
