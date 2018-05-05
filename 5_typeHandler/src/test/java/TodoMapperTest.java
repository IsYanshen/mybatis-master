import com.alpha.Address;
import com.alpha.BacklogV2;
import com.alpha.MybatisUtil;
import com.alpha.TodoMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void getBacklogV2ById() {

        BacklogV2 backlogV2 = mapper.getBacklogV2ById(2L);
        System.out.println(backlogV2.getTitle());
        System.out.println(backlogV2.getAddress().getStreet());

        System.out.println(backlogV2.getCooperators()[0].getName());
        System.out.println(backlogV2.getCooperators()[0].getEmail());
        System.out.println(backlogV2.getCooperators()[1].getName());

        System.out.println(backlogV2.getCooperators()[1].getEmail());

    }

    @Test
    void getBacklogV2ByAddress() {
        BacklogV2 backlogV2 = mapper.getBacklogV2ByAddress(new Address("BaoGuang", 43));
        System.out.println(backlogV2.getTitle());
        System.out.println(backlogV2.getAddress().getStreet());
    }

}