package top.saikaisa.healthcarebackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.DigestUtils;
import top.saikaisa.healthcarebackend.model.User;
import top.saikaisa.healthcarebackend.mapper.UserMapper;
import org.springframework.stereotype.Service;
import top.saikaisa.healthcarebackend.service.UserService;

import java.util.regex.*;

import static top.saikaisa.healthcarebackend.constant.UserConstant.USER_LOGIN_STATE;

/**
* @author Saikai
* @description 针对表【user(用户信息)】的数据库操作Service实现
* @createDate 2023-12-25 16:53:01
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Resource
    private UserMapper userMapper;

    // 盐值
    private static final String SALT = "Renjijiaohu";

    @Override
    public int userRegister(String username, String password, String checkPassword) {
        // 1.1 校验
        // 这里使用 apache 的 commons-lang3 包中的 StringUtils 类，便捷地校验字符串是否为空
        if (StringUtils.isAnyBlank(username, password, checkPassword)) {
            return -1;
        }
        if (username.length() < 4) {
            return -1;
        }
        if (password.length() < 8 || checkPassword.length() < 8) {
            return -1;
        }

        // 1.2 账户不能包含特殊字符
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%…… &*（）——+|{}【】‘；：”“’。，、？]";
        /*
         * matcher的作用是把一个字符串与正则表达式进行匹配，匹配机制是通过将正则表达式编译成一个Pattern对象，
         * 然后用Pattern对象的matcher方法创建一个Matcher对象，最后调用Matcher对象的方法进行匹配。
         * find() 的返回值是一个boolean类型的值，当匹配成功时返回true，否则返回false。
         */
        Matcher matcher = Pattern.compile(regEx).matcher(username);
        if (matcher.find()) {
            return -1;
        }

        // 1.3 密码和校验密码必须一致
        if (!password.equals(checkPassword)) {
            return -1;
        }

        // 1.4 账户不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        long count = userMapper.selectCount(queryWrapper);
        if (count > 0) {
            return -1;
        }

        // 2. 加密
        String md5Password = DigestUtils.md5DigestAsHex((SALT + password).getBytes());

        // 3. 插入数据
        User user = new User();
        user.setUsername(username);
        user.setAvatarUrl("https://img.51miz.com/Element/00/88/60/42/3cb805be_E886042_a75650be.png");
        user.setPassword(md5Password);
        // 将 user 对象插入到数据库中
        boolean saveResult = this.save(user);
        if (!saveResult) {
            return -1;
        }

        return user.getId();
    }

    @Override
    public User userLogin(String username, String password, HttpServletRequest request) {
        // 1.1 校验
        // 这里使用 apache 的 commons-lang3 包中的 StringUtils 类，便捷地校验字符串是否为空
        if (StringUtils.isAnyBlank(username, password)) {
            return null;
        }
        if (username.length() < 4) {
            return null;
        }
        if (password.length() < 8) {
            return null;
        }
        // 1.2 账户不能包含特殊字符
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%…… &*（）——+|{}【】‘；：”“’。，、？]";
        /*
         * matcher的作用是把一个字符串与正则表达式进行匹配，匹配机制是通过将正则表达式编译成一个Pattern对象，
         * 然后用Pattern对象的matcher方法创建一个Matcher对象，最后调用Matcher对象的方法进行匹配。
         * find() 的返回值是一个boolean类型的值，当匹配成功时返回true，否则返回false。
         */
        Matcher matcher = Pattern.compile(regEx).matcher(username);
        if (matcher.find()) {
            return null;
        }

        // 2. 校验密码
        String md5Password = DigestUtils.md5DigestAsHex((SALT + password).getBytes());
        // 查询用户是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("password", md5Password);
        User user = userMapper.selectOne(queryWrapper);
        // 用户不存在
        if (user == null) {
            return null;
        }

        // 3. 脱敏
        User safetyUser = getSafetyUser(user);

        // 4. 记录用户登录态
        request.getSession().setAttribute(USER_LOGIN_STATE, safetyUser);

        return safetyUser;
    }

    @Override
    public User getSafetyUser(User originUser){
        if (originUser == null) {
            return null;
        }
        User safetyUser = new User();
        BeanUtils.copyProperties(safetyUser, originUser);
        safetyUser.setPassword(null);
        safetyUser.setIsDeleted(null);

        return safetyUser;
    }

    @Override
    public int userLogout(HttpServletRequest request) {
        // 移除登录态
        request.getSession().removeAttribute(USER_LOGIN_STATE);
        return 0;
    }
}




