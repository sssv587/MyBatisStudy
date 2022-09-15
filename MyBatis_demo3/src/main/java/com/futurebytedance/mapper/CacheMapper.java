package com.futurebytedance.mapper;

import com.futurebytedance.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2022/9/15 - 16:52
 * @Description 缓存
 */
public interface CacheMapper {
    Emp getEmpByEid(@Param("eid") Integer id);

    void insertEmp(Emp emp);
}
