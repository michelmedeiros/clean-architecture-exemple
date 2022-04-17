package br.com.clean.architecture.example.rest;

import br.com.clean.architecture.example.entity.Student;
import br.com.clean.architecture.example.rest.dto.StudentDTO;
import br.com.clean.architecture.example.usecase.RegisterStudent;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StockPortfolioController {

    private final RegisterStudent registerStudent;

    @PostMapping("/register")
    public Mono<Student> registerStudent(@RequestBody StudentDTO request) {
        return registerStudent.execute(request.from());
    }

}