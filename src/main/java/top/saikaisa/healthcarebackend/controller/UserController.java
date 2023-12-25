package top.saikaisa.healthcarebackend.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.saikaisa.healthcarebackend.model.User;
import top.saikaisa.healthcarebackend.model.request.UserLoginRequest;
import top.saikaisa.healthcarebackend.model.request.UserRegisterRequest;
import top.saikaisa.healthcarebackend.service.UserService;

/**
 * @Author Saikai
 * @description 用户接口
 * @createDate 2023-12-25 17:09:45
 */
@RestController     // 适用于编写 restful 风格的 api，返回值默认为 json 类型
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    // 返回值为用户 id
    @PostMapping("/register")
    public int userResister(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
            return -1;
        }
        String username = userRegisterRequest.getUsername();
        String password = userRegisterRequest.getPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();

        // 参数不能为空
        if (StringUtils.isAnyBlank(username, password, checkPassword)) {
            return -1;
        }
        return userService.userRegister(username, password, checkPassword);
    }

    @PostMapping("/login")
    public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        //参数不能为空
        if (userLoginRequest == null) {
            return null;
        }
        String username = userLoginRequest.getUsername();
        String password = userLoginRequest.getPassword();
        // 这里再加一层校验是因为 controller 层是对参数本身的校验，而 service 层是对业务逻辑的校验
        if (StringUtils.isAnyBlank(username, password)) {
            return null;
        }
        return userService.userLogin(username, password, request);
    }

    @PostMapping("/logout")
    public int userLogout(HttpServletRequest request) {
        if (request == null) {
            return -1;
        }
        return userService.userLogout(request);
    }
}
