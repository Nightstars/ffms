package com.christ.ffms.daotest;

import com.christ.ffms.dao.UserDao;
import com.christ.ffms.entity.User;
import com.christ.ffms.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class UserDaoTest {
    static UserDao userDao=null;
    static SqlSession sqlSession=null;
    @Before
    public static void init() throws IOException {
        SqlSessionFactory sqlSessionFactory= MybatisUtil.getSqlSessionFactory();
        sqlSession=sqlSessionFactory.openSession();
        userDao=sqlSession.getMapper(UserDao.class);
    }
    @Test
    public void insertUserTest(){
        userDao.insertUser(new User("tom","Tomson","123456"));
    }
    @Test
    public void deleteUserTest(){
        userDao.deleteUser(7);
    }
    @Test
    public void modifyUserTest(){
        userDao.modifyUser(new User(8,"Jack","Jackson","123789"));
    }
    @Test
    public void selectUserByIdTest(){
        User user=userDao.selectUserById(8);
        System.out.println(user);
    }
    @Test
    public void selectAllUserTest(){
        List<User> users=userDao.selectAllUser();
        System.out.println(users);
    }
    @Test
    public void selectUserByNameAndPasswordTest(){
        User user=userDao.selectUserByNameAndPassword(new User("Jack","","1237890"));
        if(user==null){
            System.out.println("error");
        }else{
            System.out.println(user);
        }
    }
    @After
    public void destory(){
        sqlSession.commit();
        sqlSession.close();
    }
}
