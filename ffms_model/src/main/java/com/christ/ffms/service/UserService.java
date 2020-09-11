package com.christ.ffms.service;

import com.christ.ffms.dao.UserDao;
import com.christ.ffms.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Service
public class UserService {
    @Autowired
    UserDao userDao;
    @Transactional(readOnly = true, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public boolean login(User user){
        User userInfo=userDao.selectUserByNameAndPassword(user);
        if(!(userInfo==null)){
            return true;
        }else{
            return false;
        }
    }
    @Transactional(readOnly = true, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public List<User> ListUser(){
        List<User> users=userDao.selectAllUser();
        return users;
    }
    @Transactional(readOnly = false, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public Boolean addUser(User user){
        int status=userDao.insertUser(user);
        if(status>0){
            return true;
        }else {
            return false;
        }
    }
    @Transactional(readOnly = false, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public Boolean modifyUser(User user){
        int status=userDao.modifyUser(user);
        if(status>0){
            return true;
        }else {
            return false;
        }
    }
    @Transactional(readOnly = false, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public Boolean deleteUser(int id){
        int status=userDao.deleteUser(id);
        if(status>0){
            return true;
        }else {
            return false;
        }
    }
    @Transactional(readOnly = false, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public void deleteUserArr(String[] arr){
        userDao.deleteUserArr(arr);
    }
    @Transactional(readOnly = true, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public User getUserById(int id){
        return userDao.selectUserById(id);
    }
}
