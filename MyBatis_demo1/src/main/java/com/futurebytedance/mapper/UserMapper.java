package com.futurebytedance.mapper;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2022/9/12 - 21:56
 * @Description MyBatis面向切口编程的两个一致
 * 1、映射文件的namespace要和mapper接口的全类名保持一致
 * 2、映射文件中SQL语句要和mapper接口中的方法名一致
 * <p>
 * 表-实体类-mapper接口-映射文件
 */
public interface UserMapper {
    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();
}
