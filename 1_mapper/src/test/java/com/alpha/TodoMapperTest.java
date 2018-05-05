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
    void getById() {
        Backlog backlog = mapper.getById(1L);
        System.out.println(backlog.getTitle());
        System.out.println(backlog.getDescription());
        System.out.println(backlog.getPath());
        System.out.println(backlog.getDueTime());
        System.out.println(backlog.getState());
    }

    @org.junit.jupiter.api.Test
    void getAll() {
        List<Backlog> backlogs = mapper.getAll();
        backlogs.forEach(backlog -> {
            System.out.println(backlog.getTitle());
        });
    }

    @org.junit.jupiter.api.Test
    void getPendings() {
        List<Backlog> pendings = mapper.getPendings();
        pendings.forEach(backlog -> System.out.println(backlog.getTitle()));
    }

    @org.junit.jupiter.api.Test
    void delete() {
        mapper.delete(8L);
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