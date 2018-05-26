package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.criteria.CriteriaRole;
import com.ssm.entity.Role;
import com.ssm.service.RoleService;
import com.ssm.utils.LayuiJsonUtils;

@Controller
public class RoleController {
   
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value="/role",method=RequestMethod.GET)
	public String getRole() {
		return "role";
	}
	
	@ResponseBody
	@RequestMapping(value="/roleTable",produces="text/json;charset=UTF-8")
	public String roleTable(CriteriaRole criteriaRole,
			@RequestParam(value="limit",required=false)Integer pageSize) {
		
		if(pageSize == null) {
			pageSize = 10;
		}
		
		int allCount = roleService.getAllRoleCount(criteriaRole, pageSize);
		
		List<Role> data = roleService.getAllRole(criteriaRole, pageSize);
		
	    StringBuilder builder = LayuiJsonUtils.paseToJson(allCount, data);
		
		return builder.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/role",method=RequestMethod.POST)
	public String createRole(Role role) {
		roleService.createRole(role);
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="/role",method=RequestMethod.PUT)
	public String updateRole(Role role) {
		roleService.updateRole(role);
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="/role",method=RequestMethod.DELETE)
	public String deleteRole(Role role) {
		roleService.deleteRoleById(role.getId());
		return "";
	}
	
	
	
}
