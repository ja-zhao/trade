package com.mulechina.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mulechina.domain.User;
import com.mulechina.mapper.UserMapper;

@Controller
@RequestMapping({ "/home" })
public class UserController {
	@Autowired
	private UserMapper userMapper;
	
	@Value("${application.hello:Hello Angel}")
	private String hello;

	@RequestMapping(value = "/user")
	@ResponseBody
	public String user() {
		User user = userMapper.findUserByName("zhaojunfei");
		return user.getUsername() + "-----" + user.getPassword();
	}

	@RequestMapping(value = "/index")
	public String index() {
		System.out.println("12123s"+hello);
		User user = userMapper.findUserByName("zhaojunfei");
		System.out.println("12123s" + hello + user);
		return "index";
	}
}