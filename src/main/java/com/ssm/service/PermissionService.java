package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.criteria.CriteriaPermission;
import com.ssm.entity.Permission;

public interface PermissionService {
   
public void createPermission(Permission permission);  //创建一个权限
	
	public void updatePermission(Permission permission);   //更新一个权限
	  
	public Permission getPermissionById(Integer id);       //通过ID 查找对应的权限
	
	public List<Permission> getAll(CriteriaPermission criteriaPermission,int pageSize);       //获取所有的权限
    
	public List<Permission> getAll();
	
	public void deletePermissionById(Integer id);    //删除权限根据id
	
	public void deleteRolePermission(Integer userId); // 删除关联表中的字段，通过id； @param userId(用户id)

	public void insertRolePermission(Map<Integer, Integer> map); // 向关联表中插入字段，@param map: key(角色id),value(用户id)

	public int getAllCount(CriteriaPermission criteriaPermission, Integer limit);
	
	
}
