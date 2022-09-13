package com.futurebytedance.mapper;

import com.futurebytedance.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2022/9/13 - 23:03
 * @Description 查询功能接口
 */
public interface SelectMapper {
    /**
     * 根据id查询用户信息
     */
    List<User> getUserById(@Param("id") Integer id);

    /**
     * 查询所有的用户信息
     */
    List<User> getAllUser();
}
