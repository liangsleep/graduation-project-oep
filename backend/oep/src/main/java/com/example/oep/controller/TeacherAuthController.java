package com.example.oep.controller;

import com.example.oep.dto.LoginRequest;
import com.example.oep.dto.TeacherRegisterRequest;
import com.example.oep.service.TeacherAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")
public class TeacherAuthController {
    @Autowired
    private TeacherAuthService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody TeacherRegisterRequest request) {
        service.register(request);
        return ResponseEntity.ok("教师注册成功，等待审核");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        boolean success = service.login(request.getUsername(), request.getPassword());
        return success ?
                ResponseEntity.ok("教师登录成功") :
                ResponseEntity.badRequest().body("登录失败（工号/密码错误或未审核）");
    }
}