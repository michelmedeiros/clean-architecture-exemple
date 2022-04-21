package br.com.clean.architecture.example.rest;

import br.com.clean.architecture.example.rest.dto.request.StudentRequestDTO;
import br.com.clean.architecture.example.rest.dto.response.StudentResponseDTO;
import br.com.clean.architecture.example.usecase.ListAllStudents;
import br.com.clean.architecture.example.usecase.RegisterStudent;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final RegisterStudent registerStudent;
    private final ListAllStudents listAllStudents;


    @PostMapping("/register")
    public ResponseEntity<StudentResponseDTO> registerStudent(@RequestBody StudentRequestDTO request) {
        var student = registerStudent.execute(request.toDomain());
        return Optional.of(student)
                .map(std -> ResponseEntity.ok(StudentResponseDTO.fromDomain(std)))
                .orElse(ResponseEntity.unprocessableEntity().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudent() {
        var students = listAllStudents.execute().stream()
                .map(StudentResponseDTO::fromDomain)
                .collect(Collectors.toList());
        return Optional.of(students)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());

    }

}