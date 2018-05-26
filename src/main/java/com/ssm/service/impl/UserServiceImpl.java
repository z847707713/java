package com.ssm.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.criteria.CriteriaUser;
import com.ssm.dao.UserDao;
import com.ssm.entity.Permission;
import com.ssm.entity.Role;
import com.ssm.entity.User;
import com.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
   
	@Autowired
	UserDao userDao;
	 
	public User getUserByUserName(String username) {
		
		return userDao.getUserByUserName(username);
	}

	public int createUserReturnId(User user) {
		return userDao.createUserReturnId(user);
	}

	public void createUser(User user) {
        userDao.createUser(user);		
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUser(String username) {
		userDao.deleteUser(username);
	}

	public Set<String> getRoleStrByUerName(String username) {
		// TODO Auto-generated method stub
		return userDao.getRoleStrByUerName(username);
	}

	public Collection<String> getUsersPermissionStrByName(String username) {
		// TODO Auto-generated method stub
		return userDao.getUsersPermissionStrByName(username);
	}

	public List<User> getAll(CriteriaUser criteriaUser, int pageSize) {
		
		return userDao.getAll(criteriaUser, pageSize);
	}

	public List<User> getAllUserAndRole(CriteriaUser criteriaUser, int pageSize) {
		return userDao.getAllUserAndRole(criteriaUser, pageSize);
	}

	public void deleteUserRole(Integer userId) {
        userDao.deleteUserRole(userId);
	}

	public void insertUserRole(Map<Integer, Integer> map) {
		userDao.insertUserRole(map);
	}

	public List<Permission> getAllMenu() {
		return userDao.getAllMenu();
	}

	public int getAllCount(CriteriaUser criteriaUser, int pageSize) {
		
		return userDao.getAllCount(criteriaUser, pageSize);
	}

	public List<Role> getRoleByUserId(Integer id) {
		return userDao.getRoleByUserId(id);
	}
    
	@Transactional
	public void updateUserAndRole(int id, Map<Integer, Integer> map) {
		deleteUserRole(id);
		insertUserRole(map);
	}
    
}
