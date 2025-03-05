package com.example.oep.service;

import com.example.oep.entity.Admin;
import com.example.oep.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthService {
    @Autowired
    private AdminRepository adminRepo;

    public boolean login(String username, String password) {
        return adminRepo.existsByUsernameAndPassword(username, password);
    }
}
