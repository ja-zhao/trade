package com.mulechina.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mulechina.domain.User;
import com.mulechina.mapper.UserMapper;

@RestController
@RequestMapping({ "/home" })
public class UserController {
	@Autowired
	UserMapper userMapper;

	@RequestMapping(value = "/user")
	@ResponseBody
	public String user() {
		User user = userMapper.findUserByName("zhaojunfei");
		return user.getUsername() + "-----" + user.getPassword();
	}
}