package com.example.oep.service;

import com.example.oep.dto.TeacherRegisterRequest;
import com.example.oep.entity.Teacher;
import com.example.oep.exception.InvalidAuthCodeException;
import com.example.oep.exception.UserAlreadyExistsException;
import com.example.oep.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherAuthService {
    @Autowired
    private TeacherRepository teacherRepo;

    public void register(TeacherRegisterRequest request) {
        if (teacherRepo.existsByAuthCode(request.getAuthCode())) {
            throw new InvalidAuthCodeException("认证码已被使用");
        }
        if (teacherRepo.existsById(request.getTeacherId())) {
            throw new UserAlreadyExistsException("工号已存在");
        }

        Teacher teacher = new Teacher();
        teacher.setTeacherId(request.getTeacherId());
        teacher.setPassword(request.getPassword());
        teacher.setAuthCode(request.getAuthCode());
        teacher.setStatus(0);
        teacherRepo.save(teacher);
    }

    public boolean login(String username, String password) {
        Teacher teacher = teacherRepo.findById(username).orElse(null);
        return teacher != null &&
                teacher.getPassword().equals(password) &&
                teacher.getStatus() == 1;
    }
}

