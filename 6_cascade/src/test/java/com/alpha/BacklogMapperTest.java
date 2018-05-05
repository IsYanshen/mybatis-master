package com.alpha;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

class BacklogMapperTest {

    private BacklogMapper mapper;
    private SqlSession sqlSession;

    @BeforeEach
    void setUp() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(BacklogMapper.class);
    }

    @AfterEach
    void tearDown() {
        sqlSession.close();
    }

    @Test
    void getBacklogV2ById() {
        BacklogV2 backlogV2 = mapper.getBacklogV2ById(1L);
        System.out.println(backlogV2.getTitle());
        System.out.println(backlogV2.getAddress().getStreet());
        System.out.println(backlogV2.getAddress().getNumber());
        System.out.println(backlogV2.getCooperators().get(0).getName());
        System.out.println(backlogV2.getCooperators().get(0).getEmail());
        System.out.println(backlogV2.getCooperators().get(1).getName());
        System.out.println(backlogV2.getCooperators().get(1).getEmail());
    }

    @Test
    void getBacklogV2ByIdOnJoin() {
        BacklogV2 backlogV2 = mapper.getBacklogV2ByIdOnJoin(1L);
        System.out.println(backlogV2.getTitle());
        System.out.println(backlogV2.getAddress().getStreet());
    }

    @Test
    void deleteBacklogById() {
        mapper.deleteBacklogById(2L);
        sqlSession.commit();
    }

    @Test
    void insertBacklog() {
        BacklogV2 backlogV2 = new BacklogV2();
        backlogV2.setTitle("test");
        backlogV2.setDescription("it's test");
        backlogV2.setDueTime(new Date(2018));
        backlogV2.setPath(null);
        backlogV2.setAddress(new Address("BaoGuang",44));
        backlogV2.setState(BacklogState.pending);
        mapper.insertBacklog(backlogV2);
        System.out.println(backlogV2.getId());
        sqlSession.commit();

    }
}