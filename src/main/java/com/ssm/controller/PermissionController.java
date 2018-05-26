package com.ssm.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ssm.criteria.CriteriaPermission;
import com.ssm.dao.PermissionDao;
import com.ssm.entity.Permission;
import com.ssm.service.PermissionService;

@Controller
public class PermissionController {
    
	@Autowired
    PermissionService permissionService;
	
	@RequestMapping(value="/permission",method=RequestMethod.GET)
	public String showPermission() {
		return "permission";
	}
	
	@ResponseBody
	@RequestMapping(value="/permission",method=RequestMethod.POST)
	public String createPermission(Permission permission) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Date date = new Date();
		permission.setCreateBy(username);
		permission.setCreateTime(date);
		permission.setUpdateBy(username);
		permission.setUpdateTime(date);
		permissionService.createPermission(permission);
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="/permission",method=RequestMethod.PUT)
	public String updatePermission(Permission permission) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		permission.setUpdateBy(username);
		permission.setUpdateTime(new Date());
		permissionService.updatePermission(permission);
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="/permission",method=RequestMethod.DELETE)
	public String deletePermission(Permission permission) {
		permissionService.deletePermissionById(permission.getId());
		return "";
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value="/permissionTable",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
	public String showPermissionTable(@RequestParam(value="limit",required=false) Integer limit,
			CriteriaPermission criteriaPermission) throws IOException {
       
		if(limit == null) {
			limit = 10;
		}
		
		int count = permissionService.getAllCount(criteriaPermission, limit);
		List<Permission> permissions = permissionService.getAll(criteriaPermission, limit);
		StringBuilder builder = paseToJson(count, permissions);
		
		return builder.toString();
	}
	
	
	
	/**
     * 转换成前端(layui)需要的json数据
     * @param allCount
     * @param data
     * @return
     */
	private StringBuilder paseToJson(int allCount, Object data) {
		Gson gson = new Gson();
		StringBuilder sb =new StringBuilder();
		sb.append("{\"count\":");
        sb.append(allCount);
        sb.append(",\"code\":");
        sb.append(0);
        sb.append(",\"msg\":");
        sb.append("null");
        sb.append(",\"data\":");
        sb.append(gson.toJson(data));
        sb.append("}");
		return sb;
	}
	
	
}
