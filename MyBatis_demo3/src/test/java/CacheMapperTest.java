import com.futurebytedance.mapper.CacheMapper;
import com.futurebytedance.pojo.Emp;
import com.futurebytedance.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2022/9/15 - 16:53
 * @Description 缓存测试
 */
public class CacheMapperTest {
    //一级缓存
    @Test
    public void testGetEmpByEid() {
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpByEid(1);
        System.out.println(emp1);
        //mapper1.insertEmp(new Emp(null, "abc", 23, "男", "123@qq.com"));
        sqlSession1.clearCache();//清空缓存
        Emp emp2 = mapper1.getEmpByEid(1);
        System.out.println(emp2);
//        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
//        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
//        Emp emp2 = mapper2.getEmpByEid(1);
//        System.out.println(emp2);
    }
}
