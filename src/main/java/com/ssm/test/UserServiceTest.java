package com.ssm.test;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ssm.criteria.CriteriaUser;
import com.ssm.entity.Permission;
import com.ssm.entity.User;
import com.ssm.service.UserService;
@Component
public class UserServiceTest {
 
	@Autowired
	UserService userService;
	 
	@Test
	public void testGetUserByUserName() {
		init();
		User user = userService.getUserByUserName("admin");
		System.out.println(user);
		User user2 = userService.getUserByUserName("admin");
		System.out.println(user2);
	}

	private void init() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		userService = ctx.getBean(UserService.class);
	}

	@Test
	public void testCreateUserReturnId() {
		init();
		Date date = new Date();
		User user = new User();
		user.setAvailable(true);
		user.setUsername("zh");
		user.setPassword("123456");
		user.setCreateTime(date);
		user.setCreateBy("admin");
		user.setUpdateTime(date);
		user.setUpdateBy("admin");
	    userService.createUserReturnId(user);
		System.out.println(user.getId());
	}

	@Test
	public void testCreateUser() {
		init();
		Date date = new Date();
		User user = new User();
		user.setAvailable(true);
		user.setUsername("zh1");
		user.setPassword("123456");
		user.setCreateTime(date);
		user.setCreateBy("admin");
		user.setUpdateTime(date);
		user.setUpdateBy("admin");
	    userService.createUser(user);
	}

	@Test
	public void testUpdateUser() {
		init();
		User user = new User();
		Date date = new Date();
		user.setAvailable(true);
		user.setId(1);
//		user.setUsername("username");
//		user.setPassword("12345677");
		user.setUpdateTime(date);
		user.setUpdateBy("admin");
		userService.updateUser(user);
	}

	@Test
	public void testDeleteUser() {
       init();
       userService.deleteUser("zh");
	   
	}

	@Test
	public void testGetRoleStrByUerName() {
		init();
		Set<String> roles = userService.getRoleStrByUerName("username");
		System.out.println(roles);
	}

	@Test
	public void testGetUsersPermissionStrByName() {
		init();
		Collection<String> permissions = userService.getUsersPermissionStrByName("admin");
		System.out.println(permissions);
	}

	@Test
	public void testGetAll() {
		init();
		CriteriaUser criteriaUser = new CriteriaUser(1);
		//criteriaUser.setUsername("zh");
		criteriaUser.setAvailable(0);
		List<User> user = userService.getAll(criteriaUser, 3);
		System.out.println(user);
	}

	@Test
	public void testGetAllUserAndRole() {
		init();
		CriteriaUser criteriaUser = new CriteriaUser(1);
		
		List<User> users = userService.getAllUserAndRole(criteriaUser,3);
		System.out.println(users);
	}

	@Test
	public void testDeleteUserRole() {
		init();
		userService.deleteUserRole(1);
	}

	@Test
	public void testInsertUserRole() {
		init();
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		map.put(1,1);
		map.put(2,1);
		map.put(3,1);
		userService.insertUserRole(map);
	}
	
	@Test
	public void testGetAllMenu() {
		init();
		List<Permission> permissions = userService.getAllMenu();
		System.out.println(permissions);
	}
	
	@Test
	public void testGetAllCount() {
		init();
		CriteriaUser criteriaUser = new CriteriaUser(1);
		int count = userService.getAllCount(criteriaUser, 10);
		System.out.println(count);
	}

}
