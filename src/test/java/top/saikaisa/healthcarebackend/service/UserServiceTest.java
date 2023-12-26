package top.saikaisa.healthcarebackend.service;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.saikaisa.healthcarebackend.mapper.UserMapper;
import top.saikaisa.healthcarebackend.model.User;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    void testAddUser() {
        User user = new User();
        user.setUsername("testSaikai");
        user.setAvatarUrl("https://pics.saikaisa.top/avatar.jpg");
        user.setGender(0);
        user.setPassword("123");


        boolean result = userService.save(user);
        System.out.println(user.getId());
        assertTrue(result);
    }

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(1 == userList.size(), "");
        userList.forEach(System.out::println);
    }
}
