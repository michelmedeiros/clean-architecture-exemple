package br.com.clean.architecture.example.usecase;

import br.com.clean.architecture.example.contract.StudentRepository;
import br.com.clean.architecture.example.entity.Student;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListAllStudents {

    private final StudentRepository studentRepository;

    public List<Student> execute() {
        return studentRepository.listAll();
    }


}
