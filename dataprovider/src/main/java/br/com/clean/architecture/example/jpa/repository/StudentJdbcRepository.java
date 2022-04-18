package br.com.clean.architecture.example.jpa.repository;

import br.com.clean.architecture.example.jpa.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentJdbcRepository extends CrudRepository<StudentEntity, Long> {
    StudentEntity findByCpf(String numberCpf);
    StudentEntity findByMail(String mailAddress);
}
