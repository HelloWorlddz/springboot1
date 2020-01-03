package com.hzm.spingboot.model;/*
 *
 *@author hzm
 *@date 2019年08月14日 14:10
 *
 */

public class Department {
    private Integer id;
    private String departmentName;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
