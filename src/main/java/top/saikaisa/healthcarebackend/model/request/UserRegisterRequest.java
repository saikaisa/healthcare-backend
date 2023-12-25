package top.saikaisa.healthcarebackend.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Saikai
 * @description 用户注册请求体
 * @createDate 2023-12-25 17:14:40
 */
@Data
public class UserRegisterRequest implements Serializable {
    // 生成序列化 id
    private static final long serialVersionUID = -2127370162214058083L;

    private String username;

    private String password;

    private String checkPassword;
}
