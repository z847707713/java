package com.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.criteria.CriteriaRole;
import com.ssm.entity.Permission;
import com.ssm.entity.Role;
import com.ssm.service.PermissionService;
import com.ssm.service.RoleService;
import com.ssm.utils.LayuiJsonUtils;

@Controller
public class RoleBindPermissions {
     
	@Autowired
	RoleService roleService;
	@Autowired
	PermissionService permissionService;
	
	@RequestMapping("/roleBindPermissions")
	public String roleBindPermissions() {
		return "roleBindPermissions";
	}
	
	@ResponseBody
	@RequestMapping(value="/roleBindPermissionsTable",produces="text/json;charset=UTF-8")
	public String roleBindPermissionsTable(CriteriaRole criteriaRole,
			@RequestParam("limit") Integer limit) {
		if(limit == null) {
			limit = 10;
		}
		List<Role> roles = roleService.getAllRoleAndPermissions(criteriaRole, limit);
		int allCount = roleService.getAllRoleCount(criteriaRole, limit);
		List<Map<String,Object>> maps = new ArrayList<>();
		for(Role role : roles ) {
			Map<String,Object> map = new HashMap<>();
			map.put("id",role.getId());
			map.put("roleName", role.getRoleName());
			map.put("roleDesc", role.getRoleDesc());
			StringBuilder builder = new StringBuilder();
			for(int i = 0 ; i < role.getPermissions().size() ; i ++) {
				
				if( i == 0) {
					builder.append(role.getPermissions().get(i).getName());
				} else {
					builder.append("," + role.getPermissions().get(i).getName());
				}
				
			}
			map.put("permissions",builder.toString());
			maps.add(map);
		}
		return LayuiJsonUtils.paseToJson(allCount, maps).toString();
	}
	
	
	@RequestMapping(value="/bindPermissions",method=RequestMethod.GET)
	public String bindPermissions(@RequestParam("id") Integer id,Map<String,Object> map) {
		List<Permission> hasPermissions = roleService.getRolesPermissionsById(id);
		List<Permission> permissions = permissionService.getAll();
		map.put("permissions", permissions);
		map.put("hasPermissions", hasPermissions);
		return "bindPermissions";
	}
	
	@ResponseBody
	@RequestMapping(value="/bindPermissions",method=RequestMethod.PUT,produces="text/html;charset=UTF-8")
	public String bindPermissionsPut(@RequestParam(value="permissionId[]",required=false) Integer[] ids,@RequestParam("id")Integer roleId) {
		StringBuilder builder = new StringBuilder();
		if(ids == null) {
			roleService.deleteRolePermission(roleId);
		} else {
			Map<Integer,Integer> map = new HashMap<>();
			for(Integer id : ids) {
				map.put(id,roleId);
			}
		    roleService.updateRolePermisison(map, roleId);
			List<Permission> permissions = roleService.getRolesPermissionsById(roleId);
			
			for(int i = 0; i < permissions.size(); i++) {
				if(i == 0) {
					builder.append(permissions.get(i).getName());
				} else {
					builder.append("," + permissions.get(i).getName());
				}
			}
		}
		return builder.toString();
	}
	
	
	
}
