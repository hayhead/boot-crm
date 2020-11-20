package com.core.service;



import org.springframework.stereotype.Repository;

import com.core.pojo.User;



public interface UserService {
	
	public User findUser(String usercode,String password);

}
