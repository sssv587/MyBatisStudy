package com.futurebytedance.test;

import com.futurebytedance.mapper.ParameterMapper;
import com.futurebytedance.pojo.User;
import com.futurebytedance.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

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
     */

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
