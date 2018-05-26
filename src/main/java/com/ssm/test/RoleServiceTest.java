package com.ssm.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ssm.criteria.CriteriaRole;
import com.ssm.dao.RoleDao;
import com.ssm.entity.Permission;
import com.ssm.entity.Role;
import com.ssm.service.RoleService;

@Component
public class RoleServiceTest {
    
	RoleService roleService;
	
	void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		roleService = ctx.getBean(RoleService.class);
	} 
	
	@Test
	public void testGetRoleById() {
	  init();
	  
	  System.out.println(roleService.getRoleById(1));
	}

	@Test
	public void testCreateRole() {
		init();
		Date date = new Date();
		Role role = new Role();
		role.setRoleName("PO");
		role.setRoleDesc("采购部");
		role.setCreateBy("admin");
		role.setCreateTime(date);
		role.setUpdateBy("admin");
		role.setUpdateTime(date);
		roleService.createRole(role);
		
		
	}

	@Test
	public void testDeleteRoleById() {
		init();
		roleService.deleteRoleById(4);
	}

	@Test
	public void testUpdateRole() {
	   init();
	   Role role = new Role();
	   role.setId(5);
	   role.setRoleDesc("生产部门");
	   roleService.updateRole(role);
	}

	@Test
	public void testGetAllRole() {
		init();
		CriteriaRole criteriaRole = new CriteriaRole(1);
		//criteriaRole.setRoleName("admin");
		//criteriaRole.setId(1);
		//criteriaRole.setRoleDesc("生产");

		List<Role> roles = roleService.getAllRole(criteriaRole, 3);
		System.out.println(roles);
	}

	@Test
	public void testGetAllRoleAndPermissions() {
		init();
		CriteriaRole criteriaRole = new CriteriaRole(1);
		criteriaRole.setRoleName("admin");
		List<Role> roles = roleService.getAllRoleAndPermissions(criteriaRole,3);
		System.out.println(roles);
	}

	@Test
	public void testGetRolesPermissionsById() {
		init();
		List<Permission> permissions = roleService.getRolesPermissionsById(1);
		System.out.println(permissions);
	}

	@Test
	public void testDeleteUserRole() {
		
	}

	@Test
	public void testInsertUserRole() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertRolePermission() {
		init();
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		map.put(1,1);
		map.put(2,1);
		map.put(3,1);
		roleService.insertRolePermission(map);
	}

	@Test
	public void testDeleteRolePermission() {
		init();
		roleService.deleteRolePermission(1);
	}
	
	@Test
	public void roleServiceTest() {
		init();
		CriteriaRole ciCriteriaRole = new CriteriaRole(1);
	 	int count = roleService.getAllRoleCount(ciCriteriaRole, 10);
	 	System.out.println(count);
	}

}
