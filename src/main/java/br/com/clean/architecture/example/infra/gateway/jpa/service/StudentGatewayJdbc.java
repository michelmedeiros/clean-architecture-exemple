package br.com.clean.architecture.example.infra.gateway.jpa.service;

import br.com.clean.architecture.example.domain.student.Cpf;
import br.com.clean.architecture.example.domain.student.Mail;
import br.com.clean.architecture.example.domain.student.Student;
import br.com.clean.architecture.example.domain.student.StudentRepository;
import br.com.clean.architecture.example.infra.gateway.jpa.entity.StudentEntity;
import br.com.clean.architecture.example.infra.gateway.jpa.repository.StudentJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class StudentGatewayJdbc implements StudentRepository  {

    private final StudentJdbcRepository repository;

    @Override
    public Student findByCpf(Cpf cpf) {
        var entity = repository.findByCpf(cpf.getNumberCpf());
        return entity.assembly();
    }

    @Override
    public Student findByMail(Mail mail) {
        var entity = repository.findByMail(mail.getMailAddress());
        return entity.assembly();
    }

    @Override
    public Student addRegistration(Student student) {
        StudentEntity entity = StudentEntity.builder()
                .age(student.getAge())
                .cpf(student.getCpf().getNumberCpf())
                .mail(student.getMail().getMailAddress())
                .build();
        return repository.save(entity).assembly();
    }

    @Override
    public List<Student> listAll() {
        var students = repository.findAll();
        return StreamSupport.stream(students.spliterator(), false)
                .map(this::createStudent)
                .collect(Collectors.toList());
    }

    private Student createStudent(StudentEntity entity) {
        return entity.assembly();
    }
}
