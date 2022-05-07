package br.com.clean.architecture.example.jpa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;


@Tag("SlowTest")
@ActiveProfiles("integration-test")
@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ContextConfiguration(initializers = AbstractRepositoryTest.Initializer.class)
public abstract class AbstractRepositoryTest {

  @Container
  protected static final MySQLContainer MYSQL_CONTAINER =
      new MySQLContainer<>("mysql:8.0")
          .withDatabaseName("example")
          .withUsername("test")
          .withPassword("hotmart@2020")
          .withInitScript("docker/mysql/dump.sql")
          .withExposedPorts(3306);

  @SpringBootApplication
  public static class Initializer
      implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
      MYSQL_CONTAINER.start();

      TestPropertyValues.of(
          "spring.datasource.url=" + MYSQL_CONTAINER.getJdbcUrl())
          .applyTo(applicationContext);
    }
  }

}