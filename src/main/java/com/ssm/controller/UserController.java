package com.ssm.controller;

import java.util.List;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.criteria.CriteriaUser;
import com.ssm.entity.User;
import com.ssm.service.UserService;
import com.ssm.utils.LayuiJsonUtils;

@Controller
public class UserController {
     
	 @Autowired
	 UserService userService;
	 
	 @RequestMapping(value="/user",method=RequestMethod.GET)
	 public String getUser() {
		 
		 return "user";
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/userTable",method=RequestMethod.GET)
	 public String getUserTable(CriteriaUser criteriaUser,@RequestParam("limit") Integer pageSize) {
		 
		 if(pageSize == null) {
			 pageSize = 10;
		 }
		 
		 int allCount = userService.getAllCount(criteriaUser, pageSize);
		 List<User> users = userService.getAll(criteriaUser, pageSize);
		 StringBuilder builder = LayuiJsonUtils.paseToJson(allCount, users);
		 
		 return builder.toString();
	 }
	 
	 
	 @ResponseBody
	 @RequestMapping(value="/user",method=RequestMethod.POST)
	 public String createUser(User user) {
		 userService.createUser(user);
		 return "";
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/user",method=RequestMethod.PUT)
	 public String updateUser(User user) {
		 userService.updateUser(user);
		 return "";
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/user",method=RequestMethod.DELETE)
	 public String deleteUser(User user) {
		 userService.deleteUser(user.getUsername());
		 return "";
	 }
	 
	
	
}
