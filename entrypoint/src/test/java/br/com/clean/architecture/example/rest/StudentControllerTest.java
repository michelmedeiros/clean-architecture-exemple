package br.com.clean.architecture.example.rest;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import br.com.clean.architecture.example.AbstractControllerTest;
import br.com.clean.architecture.example.rest.dto.request.StudentRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;


@WebMvcTest(StudentController.class)
public class StudentControllerTest extends AbstractControllerTest {

  @Test
  void addPurchaseWithSuccess() throws Exception {
    var request = StudentRequestDTO.builder()
        .name("Maria")
        .age(10)
        .cpf("008.525.258-77")
        .password("gg1f1erev1")
        .mail("michel.tds@gmail.com")
        .build();

    var student = request.toDomain();
    when(registerStudent.execute(any())).thenReturn(student);

    mockMvc.perform(post("/students/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isOk());

  }
}