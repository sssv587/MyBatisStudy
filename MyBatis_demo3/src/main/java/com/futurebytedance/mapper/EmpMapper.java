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

    /**
     * 通过分步查询员工以及员工所对应的部门信息
     * 分步查询第一步:查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    /**
     * 通过分布查询查询部门以及部门中所有的员工信息
     * 分布查询第二步:根据did查询员工信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
