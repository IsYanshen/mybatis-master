package com.alpha;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class MybatisUtil {
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String config = "myConfig.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(config);
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
}
