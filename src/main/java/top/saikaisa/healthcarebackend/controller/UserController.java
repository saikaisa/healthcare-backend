package top.saikaisa.healthcarebackend.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import top.saikaisa.healthcarebackend.model.User;
import top.saikaisa.healthcarebackend.model.request.UserHealthDataRequest;
import top.saikaisa.healthcarebackend.model.request.UserLoginRequest;
import top.saikaisa.healthcarebackend.model.request.UserRegisterRequest;
import top.saikaisa.healthcarebackend.service.UserService;

import static top.saikaisa.healthcarebackend.constant.UserConstant.USER_LOGIN_STATE;

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

    /**
     * 用户注册
     * @param userRegisterRequest 用户注册请求
     * @return 0：注册成功，-1：注册失败
     */
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

    /**
     * 用户登录
     * @param userLoginRequest 用户登录请求
     * @param request 请求
     * @return 用户信息
     */
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

    /**
     * 用户注销
     * @param request 请求
     * @return 0：注销成功，-1：注销失败
     */
    @PostMapping("/logout")
    public int userLogout(HttpServletRequest request) {
        if (request == null) {
            return -1;
        }
        return userService.userLogout(request);
    }

    /**
     * 判断用户是否登录
     * @param request 请求
     * @return true：已登录，false：未登录
     */
    @GetMapping("/loginstate")
    public boolean userLoginState(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        // 判断 session 缓存里的用户是否为空
        return currentUser != null;
    }

    /**
     * 获取当前登录用户的信息
     * @param request 请求
     * @return 用户信息
     */
    @GetMapping("/current")
    public User getCurrentUser(HttpServletRequest request) {
        // 先检查用户是否登录
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        // 判断 session 缓存里的用户是否为空
        if (currentUser == null) {
            return null;
        }

        // 得到当前登录的用户的 id，然后根据 id 查询用户信息
        long userId = currentUser.getId();
        User user = userService.getById(userId);

        return userService.getSafetyUser(user);
    }

    /**
     * 更新用户信息
     * @param userHealthDataRequest 用户健康数据
     * @return 0：更新成功，-1：数据格式错误，-2：用户未登录，-3：其他错误
     */
    @PostMapping("/updatehealthdata")
    public int updateUserHealthData(@RequestBody UserHealthDataRequest userHealthDataRequest, HttpServletRequest request) {
        // 先检查用户是否登录
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        // 判断 session 缓存里的用户是否为空
        if (currentUser == null) {
            return -2;
        }
        // 判断用户健康数据是否为空
        if (userHealthDataRequest == null) {
            return -3;
        }

        // 检查参数是否全为空（血压处填空格也算空！）
        if (StringUtils.isAllBlank(userHealthDataRequest.getBloodPressure(),
                userHealthDataRequest.getSteps(),
                userHealthDataRequest.getCalories(),
                userHealthDataRequest.getExerciseTime(),
                userHealthDataRequest.getSleepDuration(),
                userHealthDataRequest.getSleepStartTime(),
                userHealthDataRequest.getSleepEndTime(),
                userHealthDataRequest.getHeartRate(),
                userHealthDataRequest.getBloodOxygen())) {
            return -1;
        }

        // 得到当前用户的 id
        int userId = currentUser.getId();

        return userService.updateUserHealthData(userHealthDataRequest, userId);
    }
}
