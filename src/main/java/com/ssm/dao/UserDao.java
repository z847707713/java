package com.ssm.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ssm.criteria.CriteriaUser;
import com.ssm.entity.Permission;
import com.ssm.entity.Role;
import com.ssm.entity.User;

public interface UserDao {

	
	public User getUserByUserName(String username);    // 通过用户名查找对应的user信息(过滤掉不生效的用户)

	public int createUserReturnId(User user);	  // 插入一个新的user记录，并返回对应的主键
	
	public void createUser(User user);    // 直接插入一个新的user记录
	
	public void updateUser(User user);// 更新user信息

	public void deleteUser(String username);	// 通过用户名删除该用户信息

	public Set<String> getRoleStrByUerName(String username);	// 通过用户名，查出该用户对应的所有的角色名
	
	public Collection<String> getUsersPermissionStrByName(String username);/* 通过用户名，
	                                                                      查出该用户对应的所有权限字符串的集合(例如 user:create)*/
	public List<Role> getRoleByUserId(Integer id);
	
	public List<User> getAll(CriteriaUser criteriaUser,int pageSize); //得到所有的用户信息(不包含角色及权限)
	
	public int getAllCount(CriteriaUser criteriaUser,int pageSize);
	
	public List<User> getAllUserAndRole(CriteriaUser criteriaUser,int pageSize);//得到所有的用户信息 (包含用户所拥有的角色)
 
	public void deleteUserRole(Integer userId); // 删除关联表中的字段，通过id； @param userId(用户id)

	public void insertUserRole(Map<Integer, Integer> map); // 向关联表中插入字段，@param map: key(角色id),value(用户id)
	
	public List<Permission> getAllMenu();
	
}
