package com.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.criteria.CriteriaPermission;
import com.ssm.dao.PermissionDao;
import com.ssm.entity.Permission;
import com.ssm.service.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{
    
	@Autowired
	PermissionDao permissionDao;
	
	public void createPermission(Permission permission) {
		permissionDao.createPermission(permission);
	}

	public void updatePermission(Permission permission) {
		permissionDao.updatePermission(permission);
	}

	public Permission getPermissionById(Integer id) {
		return permissionDao.getPermissionById(id);
	}

	public List<Permission> getAll(CriteriaPermission criteriaPermission, int pageSize) {
		return permissionDao.getAll(criteriaPermission, pageSize);
	}

	public void deletePermissionById(Integer id) {
		permissionDao.deletePermissionById(id);
	}

	public void deleteRolePermission(Integer roleId) {
		permissionDao.deleteRolePermission(roleId);
	}

	public void insertRolePermission(Map<Integer, Integer> map) {
		permissionDao.insertRolePermission(map);
	}

	public int getAllCount(CriteriaPermission criteriaPermission, Integer limit) {
	
		return permissionDao.getAllCount(criteriaPermission, limit);
	}

	@Override
	public List<Permission> getAll() {
		return permissionDao.getAll(null, null);
	}
  
}
