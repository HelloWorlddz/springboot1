package com.hzm.spingboot.mapper;/*
 *
 *@author hzm
 *@date 2019年08月14日 14:11
 *
 */

import com.hzm.spingboot.model.Department;
import org.apache.ibatis.annotations.*;

//@Mapper
public interface DepartmentMapper {

@Select("select * from department where id=#{sid}")
public Department findById(Integer id);

@Delete("delete from department where id=#{sid}")
public int deleById(Integer id);

//useGeneratedKeys，配置使用生成的主键
@Options(useGeneratedKeys = true,keyProperty = "id")
@Insert("insert into department(departmentName) values(#{departmentName})")
public int insertDept(Department department);

@Update("update department set departmentName=#{departmentName} where id=#{id}")
public int updateDept(Department department);

}
