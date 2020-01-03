package com.hzm.spingboot.controller;/*
 *
 *@author hzm
 *@date 2019年08月14日 15:24
 *
 */

import com.hzm.spingboot.mapper.EmployeeMapper;
import com.hzm.spingboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;
    //http://localhost:8080/emp/2
    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer sid){

        return employeeMapper.getEmpById(sid);
    }

    //http://localhost:8080/emp?lastName=hxmo1
    /*配置了sql中useGeneratedKeys=“true” keyProperty=“id” 会回填pojo属性*/
    @GetMapping("/emp")
    public Employee insertEmp(Employee employee){
        System.out.println(employee);
        employeeMapper.insertEmp(employee);
        return  employee;
    }
}
