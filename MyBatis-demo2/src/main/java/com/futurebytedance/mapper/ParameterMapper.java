package com.futurebytedance.mapper;

import com.futurebytedance.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2022/9/13 - 16:15
 * @Description 获取参数
 */
public interface ParameterMapper {
    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 验证登录(参数为map)
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 验证登录
     */
    User checkLogin(String username, String password);

    /**
     * 根据用户名查询用户信息
     */
    User getUserByUserName(String username);

    /**
     * 查询所有的员工信息
     */
    List<User> getAllUser();
}
