package com.example.oep.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TeacherRegisterRequest {
    @NotBlank(message = "账号不能为空")
    private String teacherId;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "编码不能为空")
    private String authCode;
}
