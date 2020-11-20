package com.core.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.core.pojo.User;

@Repository
public interface UserDao {
	
	public User findUser(@Param("usercode") String usercode,@Param("password") String password);
	


}
