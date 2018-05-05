package com.alpha;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

class TodoMapperTest {
    private TodoMapper mapper;
    private SqlSession sqlSession;

    @BeforeEach
    void setUp() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(TodoMapper.class);
    }

    @AfterEach
    void tearDown() {
        sqlSession.close();
    }


    @Test
    void getById1() {
        Backlog backlog = mapper.getById1(1L);
        System.out.println(backlog.getBacklogTitle());
    }

    @Test
    void getById2() {
        Backlog backlog = mapper.getById2(1L);
        System.out.println(backlog.getBacklogTitle());
    }

    @Test
    void getTiTleAndDescriptionById() {
        Map<String, String> map = mapper.getTitleAndDescriptionById(1L);
        map.entrySet().forEach(entry -> System.out.println(entry));
    }

    @Test
    void getTiTleAndDescription() {
        List<Map<String, String>> list = mapper.getTitleAndDescription();
        list.forEach(map -> System.out.println(map.entrySet()));
    }

    @Test
    void getBacklogV2ById() {

        BacklogV2 backlogV2 = mapper.getBacklogV2ById(1L);
        System.out.println(backlogV2.getTitle());
        System.out.println(backlogV2.getAddress().getStreet());
    }

    @Test
    void getBacklogV2ByAddress() {
        BacklogV2 backlogV2 = mapper.getBacklogV2ByAddress(new Address("BaoGuang", 43));
        System.out.println(backlogV2.getTitle());
        System.out.println(backlogV2.getAddress().getStreet());
    }

}