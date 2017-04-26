package com.mulechina.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mulechina.domain.User;

@Controller
@RequestMapping({ "/user" })
public class UserController {
	@Autowired
	private UserService userService;
	
	@Value("${application.hello:Hello Angel}")
	private String hello;

	@RequestMapping(value = "/user")
	@ResponseBody
	public String user(String username) {
		User user = userService.findUserByUsername(username);
		return user.getUsername() + "-----" + user.getPassword();
	}

	@RequestMapping(value = "/checklogin")
	public String checklogin(User user) {
		int cnt = userService.checklogin(user);
		if(cnt!=0){
			return "success";
		}
		return "fail";
	}
}