package br.com.clean.architecture.example.rest;

import br.com.clean.architecture.example.entity.Student;
import br.com.clean.architecture.example.rest.dto.StudentDTO;
import br.com.clean.architecture.example.usecase.ListAllStudents;
import br.com.clean.architecture.example.usecase.RegisterStudent;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final RegisterStudent registerStudent;
    private final ListAllStudents listAllStudents;


    @PostMapping("/register")
    public Student registerStudent(@RequestBody StudentDTO request) {
        return registerStudent.execute(request.from());
    }

    @GetMapping("/all")
    public List<Student> getAllStudent() {
        return listAllStudents.execute();
    }

}