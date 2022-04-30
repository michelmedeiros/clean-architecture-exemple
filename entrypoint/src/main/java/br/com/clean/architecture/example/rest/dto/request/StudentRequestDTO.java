package br.com.clean.architecture.example.rest.dto.request;

import br.com.clean.architecture.example.domain.Student;
import br.com.clean.architecture.example.vo.Cpf;
import br.com.clean.architecture.example.vo.Mail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {
    private String name;
    private String password;
    private String cpf;
    private int age;
    private String mail;

    public Student toDomain() {
        return Student.builder()
                .name(this.getName())
                .password(this.getPassword())
                .age(this.getAge())
                .cpf(new Cpf(this.getCpf()))
                .mail(new Mail(this.getMail()))
                .build();
    }
}
