package com.joker.spzx.model.dto.system;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "用户登录请求参数")
public class LoginDto {

    @NotBlank(message = "用户名不能为空")
    @Schema(description = "用户名")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Schema(description = "密码")
    private String password;

    @NotBlank(message = "验证码不能为空")
    @Schema(description = "提交验证码")
    private String captcha;

    @NotBlank(message = "验证码key不能为空")
    @Schema(description = "验证码key")
    private String codeKey;

}
