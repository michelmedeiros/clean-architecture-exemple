package br.com.clean.architecture.example.domain.student;

import br.com.clean.architecture.example.infra.exceptions.BusinessException;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Objects;

@Data
@NoArgsConstructor
@Builder
public class CellNumber {
    public static final String REGEX_CELL_NUMBER = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$\n";

    private String prefixNumber;
    private String number;

    @SneakyThrows
    public CellNumber(String prefixNumber, String number) {
        this.prefixNumber = prefixNumber;
        this.number = number;
        this.validate();
    }

    private void validate() throws BusinessException {
        if(Objects.isNull(this.prefixNumber) || Objects.isNull(this.number) ||
        !this.prefixNumber.concat(this.number).matches(REGEX_CELL_NUMBER)) {
            throw new BusinessException("Invalid cell number " + this.getPrefixNumber() +
                    this.getNumber());
        }
    }
}
