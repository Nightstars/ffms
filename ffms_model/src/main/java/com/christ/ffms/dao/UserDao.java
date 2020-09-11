package com.christ.ffms.dao;

import com.christ.ffms.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    int insertUser(User user);
    int deleteUser(int id);
    int modifyUser(User user);
    User selectUserByNameAndPassword(User user);
    User selectUserById(int id);
    List<User> selectAllUser();
    public void deleteUserArr(String[] arr);
}
