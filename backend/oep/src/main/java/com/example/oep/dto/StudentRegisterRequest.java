package com.example.oep.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class StudentRegisterRequest {
    @NotBlank(message = "账号不能为空")
    private String studentId;
    @NotBlank(message = "密码不能为空")
    private String password;
}

