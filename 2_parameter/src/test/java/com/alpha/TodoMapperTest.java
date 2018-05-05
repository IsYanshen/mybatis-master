package com.alpha;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.Date;
import java.util.List;

class TodoMapperTest {
    private TodoMapper mapper;
    private SqlSession sqlSession;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(TodoMapper.class);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        sqlSession.close();
    }



    @org.junit.jupiter.api.Test
    void delete() {
        mapper.delete(9L);
        sqlSession.commit();
    }

    @org.junit.jupiter.api.Test
    void update() {
        mapper.update(1L, BacklogState.finished);
        sqlSession.commit();
    }

    @org.junit.jupiter.api.Test
    void insert() {
        Backlog backlog1 = new Backlog("class", "javaEE techonology", null, new Date(321323), BacklogState.pending);
        Backlog backlog2 = new Backlog("homework", "programing", "doc/test.java", new Date(321323), BacklogState.pending);
        mapper.insert(backlog1);
        mapper.insert(backlog2);
        sqlSession.commit();
        System.out.println(backlog1.getTitle());
    }
}