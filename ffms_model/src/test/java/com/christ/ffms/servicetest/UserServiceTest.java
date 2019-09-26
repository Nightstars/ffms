package com.christ.ffms.servicetest;

import com.christ.ffms.entity.User;
import com.christ.ffms.service.UserService;
import org.junit.Test;

import java.io.IOException;

public class UserServiceTest {
    UserService userService=new UserService();
    @Test
    public void loginTest() throws IOException {
        System.out.println(userService.login(new User("Jack","","123789")));
    }
}
