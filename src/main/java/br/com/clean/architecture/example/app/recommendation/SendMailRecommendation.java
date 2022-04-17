package br.com.clean.architecture.example.app.recommendation;

import br.com.clean.architecture.example.domain.student.Student;

public interface SendMailRecommendation {
    void sendMail(Student student);
}
