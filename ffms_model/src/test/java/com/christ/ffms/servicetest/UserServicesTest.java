package com.christ.ffms.servicetest;

import com.christ.ffms.entity.User;
import com.christ.ffms.service.UserService;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring.xml")
@Data
public class UserServicesTest {
    @Autowired
    UserService userService;
    @Test
    public void getAllTest(){
        List<User> userList=userService.ListUser();
        System.out.println(userList );
    }
    @Test
    public void addUserTest(){
        userService.addUser(new User("Test","test","123456"));
    }
    @Test
    public void deleteUserArrTest(){
        String[] arr={"14","15"};
        userService.deleteUserArr(arr);
    }
}
