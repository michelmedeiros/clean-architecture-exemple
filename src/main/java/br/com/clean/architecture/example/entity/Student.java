package br.com.clean.architecture.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String name;
    private Cpf cpf;
    private int age;
    private Mail mail;
}
