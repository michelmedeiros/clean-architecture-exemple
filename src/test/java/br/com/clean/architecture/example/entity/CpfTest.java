package br.com.clean.architecture.example.entity;

import br.com.clean.architecture.example.infra.exceptions.BusinessException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CpfTest {

    @Test
    void nullMailTest() {
        assertThrows(BusinessException.class,
                () -> new Cpf(null));
    }

    @Test
    void invalidMailTest() {
        assertThrows(BusinessException.class,
                () -> new Cpf("1151515DLDSJHJD"));
    }

    @Test
    void validMailTest() {
        var numberCpf = "008.873.854-52";
        var cpf = new Cpf(numberCpf);
        assertThat(cpf.getNumberCpf()).isEqualTo(numberCpf);
    }
}
