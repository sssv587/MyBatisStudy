package com.futurebytedance.mapper;

import com.futurebytedance.pojo.Emp;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2022/9/14 - 20:15
 * @Description
 */
public interface EmpMapper {
    /**
     * 查询所有的员工信息
     */
    List<Emp> getAllEmp();
}
