import com.futurebytedance.mapper.DynamicSQLMapper;
import com.futurebytedance.mapper.EmpMapper;
import com.futurebytedance.pojo.Emp;
import com.futurebytedance.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2022/9/15 - 15:27
 * @Description
 */
public class DynamicSQLTest {
    /**
     * 动态SQL:
     * 1.if:根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
     */
    @Test
    public void testGetEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "", null, "男", "123@qq.com"));
        System.out.println(list);
    }
}
