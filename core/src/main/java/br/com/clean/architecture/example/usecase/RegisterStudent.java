package br.com.clean.architecture.example.usecase;

import br.com.clean.architecture.example.contract.StudentRepository;
import br.com.clean.architecture.example.domain.Student;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterStudent {

    private final StudentRepository studentRepository;

    public Student execute(Student student) {
        return studentRepository.addRegistration(student);
    }


}
