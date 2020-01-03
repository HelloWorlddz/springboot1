package com.hzm.springbootspringdatajpa;/*
 *
 *@author hzm
 *@date 2019年08月14日 12:24
 *
 */

import com.hzm.springbootspringdatajpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

    @Query(value = " from User where id= ?1")
    public  User findByJpqlId(Integer sid);
}
