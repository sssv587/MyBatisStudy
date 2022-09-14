package com.futurebytedance.mapper;

import com.futurebytedance.pojo.Emp;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 查询员工以及员工所对应的部门信息
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);
}
