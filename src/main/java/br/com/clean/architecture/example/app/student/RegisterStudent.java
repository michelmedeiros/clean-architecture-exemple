package br.com.clean.architecture.example.app.student;

import br.com.clean.architecture.example.app.student.dto.StudentDTO;
import br.com.clean.architecture.example.domain.student.Student;
import br.com.clean.architecture.example.domain.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RegisterStudent {

    private final StudentRepository studentRepository;

    public Mono<Student> execute(StudentDTO studentDTO) {
        return Mono.just(studentRepository.addRegistration(studentDTO.createStudent()));
    }


}
