package com.alpha;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
        BacklogV2 backlogV2 = mapper.getBacklogV2ById(43L);
        System.out.println(backlogV2.getTitle());
        System.out.println(backlogV2.getAddress().getStreet());
        System.out.println(backlogV2.getAddress().getNumber());
        System.out.println(backlogV2.getCooperators().get(0).getName());
        System.out.println(backlogV2.getCooperators().get(0).getEmail());
        System.out.println(backlogV2.getCooperators().get(1).getName());
        System.out.println(backlogV2.getCooperators().get(1).getEmail());
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
        backlogV2.setAddress(new Address("BaoGuang", 44));
        backlogV2.setState(BacklogState.pending);
        List<Cooperator> cooperators = backlogV2.getCooperators();
        cooperators.add(new Cooperator("alpha", "alpha@qq.com"));
        cooperators.add(new Cooperator("leyna", "leyna@qq.com"));
        mapper.insertBacklog(backlogV2);
        sqlSession.commit();

    }

    @Test
    void updateBacklog1() {
    }

    @Test
    void updateBacklog2() {
        mapper.updateBacklog2(43L, new String[]{"title", "state"}, new Object[]{"testChanged", BacklogState.finished});
        sqlSession.commit();
    }

    @Test
    void updateBacklog3() {
    }

    @Test
    void updateBacklog4() {
    }

    @Test
    void updateBacklog2Plus() {
        ArrayList<Cooperator> cooperators = new ArrayList<>();
        cooperators.add(new Cooperator("apple", "apple@qq.com"));

        cooperators.add(new Cooperator("laskin", "laskin@qq.com"));
        mapper.updateBacklog2Plus(41L, new String[]{"title", "state", "address", "cooperators"},
                new Object[]{"Changed", BacklogState.finished,
                        new Address("XiBao", 12), cooperators});
        sqlSession.commit();
    }
}