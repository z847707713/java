package com.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.criteria.CriteriaUser;
import com.ssm.entity.Role;
import com.ssm.entity.User;
import com.ssm.service.RoleService;
import com.ssm.service.UserService;
import com.ssm.utils.LayuiJsonUtils;

@Controller
public class UserBindRoleController {
   
	@RequestMapping("/userBindRoles")
	public String userBindRole() {
		
		return "userBindRoles";
	}
	
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	
	
	@ResponseBody
	@RequestMapping(value="/userBindRolesTable",produces="text/json;charset=UTF-8")
	public String userBindRolesTable(CriteriaUser criteriaUser,@RequestParam(value="limit",required=false) Integer pageSize ) {
		if(pageSize == null) {
			pageSize = 10;
		}
		List<User> users = userService.getAllUserAndRole(criteriaUser, pageSize);
		int allCount = userService.getAllCount(criteriaUser, pageSize);
		List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
		for(User user : users) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id",user.getId());
			map.put("username",user.getUsername());
			map.put("createBy",user.getCreateBy());
			map.put("creatTime",user.getCreateTime());
			map.put("updateBy",user.getUpdateBy());
			map.put("updateTime",user.getUpdateTime());
			StringBuilder str = new StringBuilder();
			for(int i=0;i<user.getRoles().size();i++) {
				if(i==0) {
					str.append(user.getRoles().get(i).getRoleName());
				} else {
					str.append("," + user.getRoles().get(i).getRoleName());
				}
			}
			
			map.put("allRoles",str.toString());
			maps.add(map);
		}
		
		StringBuilder builder = LayuiJsonUtils.paseToJson(allCount, maps);
		return builder.toString();
	}
	
	@RequestMapping(value="/bindRoles",method=RequestMethod.GET)
	public String bindRoles(@RequestParam(value="id",required=false)Integer id,
			Map<String,Object> map) {
		
		List<Role> hasRoles = userService.getRoleByUserId(id);
		List<Role> roles = roleService.getAllRole(null, null);
		map.put("hasRoles",hasRoles);
		map.put("roles",roles);
		return "bindRoles";
	}  
	
	@ResponseBody
	@RequestMapping(value="/bindRoles",method=RequestMethod.PUT)
	public String bindRolesPut(@RequestParam(value="roleId[]",required=false) Integer[] roleIds,@RequestParam("id") Integer id) {
		
		if(roleIds == null) {
			userService.deleteUserRole(id);
		}
		
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0 ; i < roleIds.length ; i++) {
			map.put(roleIds[i],id);
		}
		
	    userService.updateUserAndRole(id, map);
	    
	    List<Role> roles = userService.getRoleByUserId(id);
	    StringBuilder builder = new StringBuilder();
	    for(int i = 0 ; i < roles.size();i++) {
	    	if(i == 0) {
	    		builder.append(roles.get(i).getRoleName());
	    	} else {
	    		builder.append("," + roles.get(i).getRoleName());
	    	}
	    }
		return builder.toString();
	}  

	
	
}
