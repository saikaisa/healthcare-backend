package top.saikaisa.healthcarebackend.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Saikai
 * @description 用户登录请求体
 * @createDate 2023-12-25 17:14:22
 */
@Data
public class UserLoginRequest implements Serializable {
    // 生成序列化 id
    private static final long serialVersionUID = 895630450289179380L;

    private String username;

    private String password;
}
