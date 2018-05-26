package com.ssm.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.criteria.CriteriaPermission;
import com.ssm.entity.Permission;
import com.ssm.service.PermissionService;
import com.ssm.service.RoleService;

public class PermissionServiceTest {
    
    PermissionService permissionService;
	
	void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		permissionService = ctx.getBean(PermissionService.class);
	} 
	
	@Test
	public void testCreatePermission() {
		init();
		Date date = new Date();
		Permission permission = new Permission();
		permission.setName("生产部");
		permission.setUrl("/po");
		permission.setType("menu");
		permission.setPermission("po:*");
		permission.setCreateTime(date);
		permission.setCreateBy("admin");
		permission.setUpdateTime(date);
		permission.setUpdateBy("admin");
		permissionService.createPermission(permission);
		
	}

	@Test
	public void testUpdatePermission() {
		init();
		Date date = new Date();
		Permission permission = new Permission();
		permission.setId(4);
		permission.setName("生产部门");
//		permission.setUrl("/po");
//		permission.setType("menu");
//		permission.setPermission("po:*");
		
		permission.setUpdateTime(date);
		permission.setUpdateBy("admin");
		permissionService.updatePermission(permission);
		
	}

	@Test
	public void testGetPermissionById() {
	    init();
	    Permission permission = permissionService.getPermissionById(1);
		System.out.println(permission);
		 
	}

	@Test
	public void testGetAll() {
		init();
		CriteriaPermission criteriaPermission = new CriteriaPermission(2);
		List<Permission> permissions = permissionService.getAll(criteriaPermission, 3);
		System.out.println(permissions);
		
	}

	@Test
	public void testDeletePermissionById() {
	   init();
	   permissionService.deletePermissionById(5);
	}

	@Test
	public void testDeleteUserRole() {
		init();
		permissionService.deleteRolePermission(2);
	}

	@Test
	public void testInsertUserRole() {
		init();
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		map.put(2, 1);
		map.put(3, 1);
		permissionService.insertRolePermission(map);
	}

}
