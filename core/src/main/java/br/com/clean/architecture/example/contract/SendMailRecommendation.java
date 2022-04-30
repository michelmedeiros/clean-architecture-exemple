package br.com.clean.architecture.example.contract;


import br.com.clean.architecture.example.domain.Student;

public interface SendMailRecommendation {
    void sendMail(Student student);
}
