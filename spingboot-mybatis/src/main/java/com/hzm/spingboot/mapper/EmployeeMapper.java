package com.hzm.spingboot.mapper;/*
 *
 *@author hzm
 *@date 2019年08月14日 14:21
 *
 */

import com.hzm.spingboot.model.Employee;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
