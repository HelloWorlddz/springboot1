package com.hzm.spingboot.controller;/*
 *
 *@author hzm
 *@date 2019年08月14日 14:29
 */

import com.hzm.spingboot.mapper.DepartmentMapper;
import com.hzm.spingboot.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer sid){

        return departmentMapper.findById(sid);
    }

    //http://localhost:8080/dept?departmentName=hxm
    //因为配置了使用生成的主键,所以返回的json是包含主键的,如果在DepartmentMapper未配置使用主键，则显示的主键值为null。
    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }
}
