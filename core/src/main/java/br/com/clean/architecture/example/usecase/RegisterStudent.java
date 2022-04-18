package br.com.clean.architecture.example.usecase;

import br.com.clean.architecture.example.contract.StudentRepository;
import br.com.clean.architecture.example.entity.Student;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RegisterStudent {

    private final StudentRepository studentRepository;

    public Mono<Student> execute(Student student) {
        return Mono.just(studentRepository.addRegistration(student));
    }


}
