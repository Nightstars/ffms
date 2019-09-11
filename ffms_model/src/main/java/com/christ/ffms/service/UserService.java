package com.christ.ffms.service;

import com.christ.ffms.dao.UserDao;
import com.christ.ffms.entity.User;
import com.christ.ffms.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

public class UserService {
    UserDao userDao=null;
    SqlSession sqlSession=null;
    SqlSessionFactory sqlSessionFactory=null;
    public void init() throws IOException {
        sqlSessionFactory=MybatisUtil.getSqlSessionFactory();
        sqlSession=sqlSessionFactory.openSession();
        userDao=sqlSession.getMapper(UserDao.class);
    }
    public void destory(){
        sqlSession.commit();
        sqlSession.close();
    }
    public boolean login(User user) throws IOException {
        init();
        User userInfo=userDao.selectUserByNameAndPassword(user);
        destory();
        if(!(userInfo==null)){
            return true;
        }else{
            return false;
        }
    }
    public List<User> ListUser() throws IOException {
        init();
        List<User> users=userDao.selectAllUser();
        destory();
        return users;
    }
}
