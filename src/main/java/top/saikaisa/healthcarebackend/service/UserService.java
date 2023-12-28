package top.saikaisa.healthcarebackend.service;

import jakarta.servlet.http.HttpServletRequest;
import top.saikaisa.healthcarebackend.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import top.saikaisa.healthcarebackend.model.request.UserHealthDataRequest;

/**
* @author Saikai
* @description 针对表【user(用户信息)】的数据库操作Service
* @createDate 2023-12-25 16:53:01
*/
public interface UserService extends IService<User> {
    /**
     * @param userAccount   用户账号
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    int userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     *
     * @param userAccount   用户账号
     * @param userPassword  用户密码
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser 原始用户信息
     * @return 脱敏后的用户信息
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销
     *
     * @param request
     * @return 0
     */
    int userLogout(HttpServletRequest request);

    int updateUserHealthData(UserHealthDataRequest userHealthDataRequest, int userId);
}
