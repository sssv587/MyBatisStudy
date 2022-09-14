import com.futurebytedance.mapper.EmpMapper;
import com.futurebytedance.pojo.Emp;
import com.futurebytedance.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2022/9/14 - 20:19
 * @Description 测试类
 */
public class ResultMapTest {
    /**
     * 解决字段名和属性名不一致的情况
     * a> 为字段起别名,保持和属性名的一致
     * b> 设置全局配置,将_自动映射为驼峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     */
    @Test
    public void testGetAllEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(System.out::println);
    }
}
