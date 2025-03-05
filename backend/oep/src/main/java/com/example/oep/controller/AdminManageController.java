package com.example.oep.controller;


import com.example.oep.entity.Teacher;
import com.example.oep.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/manage")
public class AdminManageController {

    @Autowired
    private TeacherRepository teacherRepo;

    // 获取待审核教师列表
    @GetMapping("/teachers/pending")
    public List<Teacher> getPendingTeachers() {
        return teacherRepo.findByStatus(0);
    }

    // 批准教师注册
    @PostMapping("/teachers/{teacherId}/approve")
    public ResponseEntity<?> approveTeacher(@PathVariable String teacherId) {
        Optional<Teacher> teacherOpt = teacherRepo.findById(teacherId);
        if (teacherOpt.isPresent()) {
            Teacher teacher = teacherOpt.get();
            teacher.setStatus(1);
            teacherRepo.save(teacher);
            return ResponseEntity.ok("审批通过");
        }
        return ResponseEntity.badRequest().body("教师不存在");
    }
}