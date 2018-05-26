package com.ssm.controller;

import java.util.List;
import java.util.Map;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssm.entity.Permission;
import com.ssm.service.UserService;

@Controller
public class LoginController {
    
	@Autowired
	UserService userService;
	
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username,
			 @RequestParam("password") String password) {
		Subject currentUser = SecurityUtils.getSubject();
		 if(!currentUser.isAuthenticated()) {
			  UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			  token.setRememberMe(true);
			  try {
				  currentUser.login(token);
			  } catch(Exception e) {
				  System.out.println("µÇÂ½Ê§°Ü" + e.getMessage());
			  }
		 }
		return "redirect:index";
	}
	
	
	@RequestMapping("/index")
	public String index(Map<String,Object> map) {
		List<Permission> menus = userService.getAllMenu();
		map.put("menus", menus);
		return "index";
	}
	
	
}
