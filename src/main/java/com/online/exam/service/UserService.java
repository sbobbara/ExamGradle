package com.online.exam.service;

import org.springframework.stereotype.Service;

import com.online.exam.entity.UserDetails;


@Service
public interface UserService {
	
	UserDetails login(UserDetails userDetails);

	boolean add(UserDetails user);
}
