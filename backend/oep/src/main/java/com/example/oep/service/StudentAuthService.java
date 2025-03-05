package com.example.oep.service;

import com.example.oep.dto.StudentRegisterRequest;
import com.example.oep.entity.Student;
import com.example.oep.exception.UserAlreadyExistsException;
import com.example.oep.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentAuthService {
    @Autowired
    private StudentRepository studentRepo;

    public void register(StudentRegisterRequest request) {
        if (studentRepo.existsById(request.getStudentId())) {
            throw new UserAlreadyExistsException("学号已存在");
        }
        Student student = new Student();
        student.setStudentId(request.getStudentId());
        student.setPassword(request.getPassword());
        studentRepo.save(student);
    }

    public boolean login(String username, String password) {
        return studentRepo.existsByStudentIdAndPassword(username, password);
    }
}