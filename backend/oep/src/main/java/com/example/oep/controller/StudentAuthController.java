package com.example.oep.controller;

//import com.example.oep.dto.LoginRequest;
//import com.example.oep.dto.StudentRegisterRequest;
//import com.example.oep.entity.Student;
//import com.example.oep.repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/student")
//public class StudentAuthController {
//
////    @Autowired
////    private StudentRepository studentRepo;
//
//    private final StudentRepository studentRepo;
//
//    @Autowired // 构造函数注入（推荐）
//    public StudentAuthController(StudentRepository studentRepo) {
//        this.studentRepo = studentRepo;
//    }
//
//    // 学生注册
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody StudentRegisterRequest request) {
//        if (studentRepo.existsById(request.getStudent_id())) {
//            return ResponseEntity.badRequest().body("学号已存在");
//        }
//        Student student = new Student();
//        student.setStudent_id(request.getStudent_id());
//        student.setPassword(request.getPassword()); // 实际应加密存储
//        studentRepo.save(student);
//        return ResponseEntity.ok("注册成功");
//    }
//
//    // 学生登录
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//        Optional<Student> student = studentRepo.findById(request.getUsername());
//        if (student.isPresent() && student.get().getPassword().equals(request.getPassword())) {
//            return ResponseEntity.ok("登录成功");
//        }
//        return ResponseEntity.badRequest().body("学号或密码错误");
//    }
//}


import com.example.oep.dto.LoginRequest;
import com.example.oep.dto.StudentRegisterRequest;
import com.example.oep.service.StudentAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentAuthController {
    @Autowired
    private StudentAuthService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody StudentRegisterRequest request) {
        service.register(request);
        return ResponseEntity.ok("学生注册成功");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        boolean success = service.login(request.getUsername(), request.getPassword());
        return success ?
                ResponseEntity.ok("学生登录成功") :
                ResponseEntity.badRequest().body("学号或密码错误");
    }
}