package br.com.clean.architecture.example.domain.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String cep;
    private String nameAddress;
    private int numberAddress;
    private String complement;

}
