package com.futurebytedance.mapper;

import com.futurebytedance.pojo.Emp;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2022/9/15 - 15:21
 * @Description 动态SQL
 */
public interface DynamicSQLMapper {
    /**
     * 多条件查询
     */
    List<Emp> getEmpByCondition(Emp emp);
}
