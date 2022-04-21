package br.com.clean.architecture.example.rest.dto.response;

import br.com.clean.architecture.example.entity.Student;
import br.com.clean.architecture.example.vo.Cpf;
import br.com.clean.architecture.example.vo.Mail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDTO {
    private Long id;
    private String name;
    private String password;
    private String cpf;
    private int age;
    private String mail;

    public static StudentResponseDTO fromDomain(Student student) {
        return StudentResponseDTO.builder()
                .name(student.getName())
                .password(student.getPassword())
                .age(student.getAge())
                .cpf(student.getCpf().getNumberCpf())
                .mail(student.getMail().getMailAddress())
                .build();
    }
}
