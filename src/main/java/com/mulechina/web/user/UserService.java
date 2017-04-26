package com.mulechina.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulechina.domain.User;
import com.mulechina.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}

	public int checklogin(User user) {
		return userMapper.checklogin(user);
	}
}
