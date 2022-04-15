package br.com.clean.architecture.example.entity;

import br.com.clean.architecture.example.infra.exceptions.BusinessException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MailTest {

    @Test
    void nullMailTest() {
        assertThrows(BusinessException.class,
                () -> new Mail(null));
    }

    @Test
    void invalidMailTest() {
        assertThrows(BusinessException.class,
                () -> new Mail("micheltds.gmail.com"));
    }

    @Test
    void validMailTest() {
        var mail = new Mail("michel.tds@gmail.com");
        assertThat(mail.getMailAddress()).isEqualTo("michel.tds@gmail.com");
    }
}
