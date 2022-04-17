package br.com.clean.architecture.example.app.student.dto;

import br.com.clean.architecture.example.domain.student.Cpf;
import br.com.clean.architecture.example.domain.student.Mail;
import br.com.clean.architecture.example.domain.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private String password;
    private String cpf;
    private int age;
    private String mail;

    public Student createStudent() {
        return Student.builder()
                .name(this.getName())
                .password(this.getPassword())
                .age(this.getAge())
                .cpf(new Cpf(this.getCpf()))
                .mail(new Mail(this.getMail()))
                .build();
    }
}
