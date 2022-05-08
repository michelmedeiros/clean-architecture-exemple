package br.com.clean.architecture.example.jpa.gateway;

import br.com.clean.architecture.example.contract.StudentRepository;
import br.com.clean.architecture.example.domain.Student;
import br.com.clean.architecture.example.jpa.entity.StudentEntity;
import br.com.clean.architecture.example.jpa.repository.StudentJpaRepository;
import br.com.clean.architecture.example.vo.Cpf;
import br.com.clean.architecture.example.vo.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Repository
public class StudentJpaGateway implements StudentRepository {

    @Autowired
    private final StudentJpaRepository repository;

    @Override
    public Student findByCpf(Cpf cpf) {
        var entity = repository.findByCpf(cpf.getNumberCpf());
        return entity.fromEntity();
    }

    @Override
    public Student findByMail(Mail mail) {
        var entity = repository.findByMail(mail.getMailAddress());
        return entity.fromEntity();
    }

    @Override
    public Student addRegistration(Student student) {
        StudentEntity entity = StudentEntity.builder()
                .age(student.getAge())
                .name(student.getName())
                .password(student.getPassword())
                .cpf(student.getCpf().getNumberCpf())
                .mail(student.getMail().getMailAddress())
                .build();
        return repository.save(entity).fromEntity();
    }

    @Override
    public List<Student> listAll() {
        var students = repository.findAll();
        return StreamSupport.stream(students.spliterator(), false)
                .map(this::createStudent)
                .collect(Collectors.toList());
    }

    private Student createStudent(StudentEntity entity) {
        return entity.fromEntity();
    }
}
