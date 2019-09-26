package com.christ.ffms.daotest;

import com.christ.ffms.dao.ItemDao;
import com.christ.ffms.entity.Item;
import com.christ.ffms.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;


public class ItemDaoTest {
    ItemDao itemDao=null;
    SqlSession sqlSession=null;
    @Before
    public void init() throws IOException {
        SqlSessionFactory sqlSessionFactory= MybatisUtil.getSqlSessionFactory();
        sqlSession=sqlSessionFactory.openSession();
        itemDao=sqlSession.getMapper(ItemDao.class);
    }

    @Test
    public void selectItems(){
        Item item=itemDao.getItemByPK(2);
        System.out.println(item);
    }

    @After
    public void destory(){
        sqlSession.commit();
        sqlSession.close();
    }
}
