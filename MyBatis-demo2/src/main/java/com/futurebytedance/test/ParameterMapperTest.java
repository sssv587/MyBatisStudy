package com.futurebytedance.test;

import com.futurebytedance.mapper.ParameterMapper;
import com.futurebytedance.pojo.User;
import com.futurebytedance.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2022/9/13 - 16:20
 * @Description 测试类
 */
public class ParameterMapperTest {
    /**
     * MyBatis获取参数值得两种方式:${}和#{}
     * ${}本质字符串拼接
     * #{}本质占位符赋值
     * MyBatis获取参数值的各种情况:
     * 1、mapper接口方法的参数为单个的字面量类型
     * 可以通过${}和#{}以任意的名称获取参数值,但是需要注意${}的单引号问题
     * 2、mapper接口方法的参数为多个时
     * 此时MyBatis会将这些参数放在一个map集合中,以两种方式进行存储
     * a>以arg0,arg1... 为键,以参数为值
     * b>以param1,param2... 为键,以参数为值
     * 因此只需要通过#{}和${}以键的方式访问值即可,但是需要注意${}的单引号问题
     * 3、若mapper接口方法的参数有多个时,可以手动将这些参数放在一个map中存储
     * 只需要通过#{}和${}以键的方式访问值即可,但是需要注意${}的单引号问题
     * 4、mapper接口方法的参数是一个实体类类型的参数
     * 只需要通过#{}和${}以属性的方式属性值即可,但是需要注意${}的单引号问题
     * 5、使用@Param注解命名参数
     * 此时MyBatis会将这些参数放在一个map集合中,以两种方式进行存储
     * a>以@Param注解的值为键,以参数为值
     * b>以param1,param2... 为键,以参数为值
     * 需要通过#{}和${}以属性的方式属性值即可,但是需要注意${}的单引号问题
     */

    @Test
    public void testCheckLoginByParam() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("admin", "123456");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.insertUser(new User(null, "李四", "123", 23, "男", "123@qq.com"));
        System.out.println(result);
    }

    @Test
    public void checkLoginByMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void checkLogin() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("admin", "123456");
        System.out.println(user);
    }

    @Test
    public void getUserByUserName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUserName("admin");
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
    }

    @Test
    public void testJDBC() throws Exception {
        String username = "admin";
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
        connection.prepareStatement("select * from t_user where username = '" + username + "'");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from t_user where username=?");
        preparedStatement.setString(1, username);
    }
}
