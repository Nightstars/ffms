package com.christ.ffms.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;

public class MybatisUtilTest {
    @Test
    public void getConnectionTest() throws IOException {
        SqlSessionFactory sqlSessionFactory=MybatisUtil.getSqlSessionFactory();
        System.out.println(sqlSessionFactory);
    }
}
