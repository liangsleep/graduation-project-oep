package com.example.oep.repository;

import com.example.oep.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
    List<Teacher> findByStatus(Integer status); // 按状态查询教师
    boolean existsByAuthCode(String authCode);
}