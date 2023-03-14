package com.online.exam.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.online.exam.dao.UserDao;
import com.online.exam.entity.UserDetails;
import com.online.exam.exception.AuthenticationFailedException;
import com.online.exam.exception.InvalidUserRoleException;
import com.online.exam.exception.UserAlreadyExistException;

@Component
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao uDao;
	
	@Override
	public UserDetails login(UserDetails userDetails) {
		System.out.println(uDao);
		String role = "";
		//Optional<UserDetails> op = uDao.findById(userDetails.getUserId());
		UserDetails userDb = uDao.findByName(userDetails.getUserName());
        if(userDb==null){
            throw new AuthenticationFailedException("No User found for username= "+userDetails.getUserName());
        }
		if(!userDetails.getPassword().equals(userDb.getPassword())) {
            throw new AuthenticationFailedException("Authentication failed for username= ");
		}
		return userDb ;
	}
	@Override
	public boolean add(UserDetails user) {
		if(uDao.existsById(user.getUserId())) {
			throw new UserAlreadyExistException("You have already registered to Matrimony. please log in");
		}
		if (user.getUserRole().equalsIgnoreCase("Admin") || user.getUserRole().equalsIgnoreCase("mediator")
				||user.getUserRole().equalsIgnoreCase("customer")) {
				uDao.save(user);
		}
		else {
			throw new InvalidUserRoleException("Invalid UserRole");
		}
		return true;
	}
}
