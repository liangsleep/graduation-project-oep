package com.example.oep.repository;

import com.example.oep.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    boolean existsByStudentIdAndPassword(String username, String password);
}