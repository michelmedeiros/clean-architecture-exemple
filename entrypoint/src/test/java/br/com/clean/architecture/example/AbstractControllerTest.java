package br.com.clean.architecture.example;

import br.com.clean.architecture.example.usecase.ListAllStudents;
import br.com.clean.architecture.example.usecase.RegisterStudent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@Tag("SlowTest")
@ActiveProfiles("integration-test")
@Import(AbstractControllerTest.TestConfiguration.class)
public class AbstractControllerTest {

  @Autowired
  protected MockMvc mockMvc;

  @MockBean
  protected ListAllStudents listAllStudents;

  @MockBean
  protected RegisterStudent registerStudent;


  @Autowired
  protected ObjectMapper objectMapper;

  @SpringBootApplication
  static class TestConfiguration {
  }
}