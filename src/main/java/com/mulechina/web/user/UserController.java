package com.mulechina.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mulechina.aop.RequestLimit;
import com.mulechina.aop.Token;
import com.mulechina.domain.User;

@Controller
@RequestMapping({ "/user" })
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;

	@Value("${application.hello:Hello Angel}")
	private String hello;
	@Token(remove = true)
	@RequestMapping(value = "/user")
	@ResponseBody
	public String user(String username,HttpServletRequest request, HttpServletResponse response) {
		logger.info("查询相关账户信息.查询用户:{}",username);
		User user = userService.findUserByUsername(username);
		return user.getUsername() + "-----" + user.getPassword();
	}

	@RequestMapping(value = "/checklogin")
	public String checklogin(User user) {
		logger.info("验证用户名:{} 密码:{}",user.getUsername(),user.getPassword());
		int cnt = userService.checklogin(user);
		if (cnt != 0) {
			logger.info("登录成功");
			return "success";
		}
		logger.info("登录失败");
		return "fail";
	}
	
	@RequestMapping("/hello")
	@RequestLimit(count = 10)
	public String hello(HttpServletRequest request) {
		
		return "fail";
	}
}