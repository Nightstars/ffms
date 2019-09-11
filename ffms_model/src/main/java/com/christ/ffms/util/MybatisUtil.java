package com.christ.ffms.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory=null;
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        if(sqlSessionFactory==null){
            Reader reader= Resources.getResourceAsReader("configure.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        }
        return sqlSessionFactory;
    }
}
