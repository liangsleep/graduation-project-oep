package com.example.oep.controller;
import com.example.oep.dto.LoginRequest;
import com.example.oep.service.AdminAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminAuthController {
    @Autowired
    private AdminAuthService service;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        boolean success = service.login(request.getUsername(), request.getPassword());
        return success ?
                ResponseEntity.ok("管理员登录成功") :
                ResponseEntity.badRequest().body("用户名或密码错误");
    }
}

