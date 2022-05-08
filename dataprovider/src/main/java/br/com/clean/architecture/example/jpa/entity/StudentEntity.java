package br.com.clean.architecture.example.jpa.entity;

import br.com.clean.architecture.example.domain.Student;
import br.com.clean.architecture.example.vo.Cpf;
import br.com.clean.architecture.example.vo.Mail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "student")
public class StudentEntity {

    @Id
    private Long id;
    @Column(value = "first_name")
    private String name;
    @Column(value = "passwd")
    private String password;
    private String cpf;
    private int age;
    private String mail;

    public Student fromEntity() {
        return Student.builder()
                .id(this.getId())
                .mail(new Mail(this.getMail()))
                .cpf(new Cpf(this.getCpf()))
                .age(this.getAge())
                .name(this.getName())
                .password(this.getPassword())
                .build();
    }
}
