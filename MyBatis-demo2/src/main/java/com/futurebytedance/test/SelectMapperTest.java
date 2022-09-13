package com.futurebytedance.test;

import com.futurebytedance.mapper.SelectMapper;
import com.futurebytedance.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2022/9/13 - 23:37
 * @Description 测试类
 */
public class SelectMapperTest {
    /**
     * MyBatis的各种查询功能:
     * 1、若查询出的数据只有一条
     * a>可以通过实体类对象或者集合接收
     * b>可以通过list集合接收
     * c>可以通过map集合接收
     * 结果:{password=123456, sex=男, id=3, age=23, email=12345@qq.com, username=admin}
     * 2、若查询出的数据有多条
     * a>可以通过list集合接收
     * b>
     * 注意:一定不能通过实体类对象接收结果,此时会抛异常TooManyResultException
     *
     * MyBatis中设置了默认的类型别名
     * Java.lang.Integer--->int,integer
     * int--->_int,_integer
     * Map--->map
     * String--->string
     */

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(3));
    }

    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(3));
    }
}
