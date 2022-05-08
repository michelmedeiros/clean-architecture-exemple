package br.com.clean.architecture.example.rest.dto.response;

import br.com.clean.architecture.example.domain.Student;
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
                .id(student.getId())
                .name(student.getName())
                .password(student.getPassword())
                .age(student.getAge())
                .cpf(student.getCpf().getNumberCpf())
                .mail(student.getMail().getMailAddress())
                .build();
    }
}
