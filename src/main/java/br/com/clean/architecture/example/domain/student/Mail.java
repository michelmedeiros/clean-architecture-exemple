package br.com.clean.architecture.example.domain.student;

import br.com.clean.architecture.example.infra.exceptions.BusinessException;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Mail {

    public static final String REGEX_MAIL = "[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*";

    private String mailAddress;

    @SneakyThrows
    public Mail(final String mailAddress) {
        this.mailAddress = mailAddress;
        this.validateMail();
    }

    private void validateMail() throws BusinessException {
        if (Objects.isNull(this.mailAddress) || !this.mailAddress.matches(REGEX_MAIL)) {
            throw new BusinessException("Invalid mail: " + this.mailAddress);
        }
    }
}
