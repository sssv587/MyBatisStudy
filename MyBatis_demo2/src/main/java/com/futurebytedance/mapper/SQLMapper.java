package com.futurebytedance.mapper;

import com.futurebytedance.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2022/9/14 - 0:10
 * @Description
 */
public interface SQLMapper {
    /**
     * 根据用户名模糊查询用户信息
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * 批量删除
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * 查询指定表中的数据
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    /**
     * 添加用户信息
     */
    void insertUser(User user);
}
