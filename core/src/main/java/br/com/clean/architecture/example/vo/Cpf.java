package br.com.clean.architecture.example.vo;

import br.com.clean.architecture.example.exceptions.BusinessException;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Cpf {

    public static final String  REGEX_CPF = "(^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$)";

    private String numberCpf;

    @SneakyThrows
    public Cpf(final String numberCpf) {
        this.numberCpf = numberCpf;
        validate();
    }

    private void validate() throws BusinessException {
        if(Objects.isNull(this.numberCpf) || !numberCpf.matches(REGEX_CPF)) {
            throw new BusinessException("Invalid Cpf with number: " + this.numberCpf);
        }
    }

}
