package com.online.exam.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.online.exam.entity.UserDetails;


@Repository
public interface UserDao extends JpaRepository<UserDetails,Integer>{

//	Customer getByUserId(Integer customerId);
    @Query(value= "select u from UserDetails u where u.userName=?1")
	UserDetails findByName(String userName);

}

