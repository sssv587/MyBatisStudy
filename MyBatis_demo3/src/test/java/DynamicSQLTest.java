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
     * 2.where:
     * 当where标签中有内容时,会自动生成where关键字,并且将内容前多余的and或or去掉
     * 当where标签中没有内容时,此时where标签没有任何效果
     * 注意:where标签不能将其中内容后面多余的and或or去掉
     * 3.trim:
     * 若标签中有内容时:
     * prefix|suffix:将trim标签中内容前面或后面添加指定内容
     * prefixOverrides|suffixOverrides:将trim标签中内容前面或后面去掉指定内容
     * 若标签中没有内容时,trim标签也没有任何效果
     * 4.choose、when、otherwise 相当于if...else if...else
     * when至少要有一个,otherwise最多只能有一个
     * 5.foreach
     */
    @Test
    public void testDeleteMoreByArray() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{6, 7, 8});
        System.out.println(result);
    }

    @Test
    public void testGetEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByChoose(new Emp(null, "张三", 23, "男", "123@qq.com"));
        System.out.println(list);
    }

    @Test
    public void testGetEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "", null, "", ""));
        System.out.println(list);
    }
}
