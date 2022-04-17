package br.com.clean.architecture.example.domain.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("student")
public class Student {

    public static final int LIMIT_CELL_NUMBERS = 10;
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
