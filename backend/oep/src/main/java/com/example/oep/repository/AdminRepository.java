package com.example.oep.repository;

import com.example.oep.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
    boolean existsByUsernameAndPassword(String username, String password);
}
