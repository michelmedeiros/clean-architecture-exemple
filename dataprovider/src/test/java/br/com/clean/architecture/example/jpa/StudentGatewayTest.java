package br.com.clean.architecture.example.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.clean.architecture.example.domain.Student;
import br.com.clean.architecture.example.jpa.gateway.StudentJpaGateway;
import br.com.clean.architecture.example.vo.Cpf;
import br.com.clean.architecture.example.vo.Mail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentGatewayTest extends AbstractRepositoryTest {

  @Autowired
  private StudentJpaGateway repository;

  @DisplayName("When save student with success")
  @Test
  void savePurchaseWithSuccess() {
    var cpf = "008.852.855-55";
    var student = this.createStudentByCpf(cpf);
    var result = repository.addRegistration(student);
    assertThat(result.getCpf().getNumberCpf()).isEqualTo(cpf);
  }

  private Student createStudentByCpf(String cpf) {
    return Student.builder()
        .cpf(new Cpf(cpf))
        .mail(new Mail("michel@gmail.com"))
        .name("Michel")
        .age(100)
        .build();
  }

}