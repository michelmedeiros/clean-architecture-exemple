package br.com.clean.architecture.example.domain;

import br.com.clean.architecture.example.vo.CellNumber;
import br.com.clean.architecture.example.vo.Cpf;
import br.com.clean.architecture.example.vo.Mail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    public static final int LIMIT_CELL_NUMBERS = 10;
    private Long id;
    private String name;
    private Cpf cpf;
    private int age;
    private Mail mail;
    private String password;
    private List<CellNumber> cellNumbers = new ArrayList<>(LIMIT_CELL_NUMBERS);

    public void addCellNumbers(String prefixNumber, String number) {
        if(LIMIT_CELL_NUMBERS < this.cellNumbers.size()) {
            this.cellNumbers.add(CellNumber.builder()
                    .prefixNumber(prefixNumber)
                    .number(number)
                    .build());
        }
    }
}
