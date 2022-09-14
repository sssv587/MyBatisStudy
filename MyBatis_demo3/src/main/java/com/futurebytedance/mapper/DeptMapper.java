package com.futurebytedance.mapper;

import com.futurebytedance.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2022/9/14 - 20:15
 * @Description
 */
public interface DeptMapper {
    /**
     * 通过分步查询员工以及员工所对应的部门信息
     * 分步查询第二步:通过did查询员工所对应的部门
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /**
     * 获取部门以及部门中所有的员工信息
     */
    Dept getDeptAndEmp(@Param("did") Integer did);
}
