package com.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.criteria.CriteriaRole;
import com.ssm.dao.RoleDao;
import com.ssm.entity.Permission;
import com.ssm.entity.Role;
import com.ssm.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;

	public Role getRoleById(Integer id) {

		return roleDao.getRoleById(id);
	}

	public void createRole(Role role) {
		roleDao.createRole(role);
	}

	public void deleteRoleById(Integer id) {
		roleDao.deleteRoleById(id);
	}

	public void updateRole(Role role) {
		roleDao.updateRole(role);
	}

	public List<Role> getAllRole(CriteriaRole criteriaRole, Integer pageSize) {
		return roleDao.getAllRole(criteriaRole, pageSize);
	}

	public List<Role> getAllRoleAndPermissions(CriteriaRole criteriaRole, Integer pageSize) {
		return roleDao.getAllRoleAndPermissions(criteriaRole, pageSize);
	}

	public void deleteUserRole(Integer userId) {
		roleDao.deleteUserRole(userId);

	}

	public void insertUserRole(Map<Integer, Integer> map) {
		roleDao.insertUserRole(map);
	}

	public void insertRolePermission(Map<Integer, Integer> map) {
		roleDao.insertRolePermission(map);
	}

	public void deleteRolePermission(Integer roleId) {
		roleDao.deleteRolePermission(roleId);
	}

	public List<Permission> getRolesPermissionsById(Integer id) {
		return roleDao.getRolesPermissionsById(id);
	}

	public int getAllRoleCount(CriteriaRole criteriaRole, Integer pageSize) {
		
		return roleDao.getAllRoleCount(criteriaRole, pageSize);
	}

	@Transactional
	public void updateRolePermisison(Map<Integer, Integer> map, Integer roleId) {
		
		roleDao.deleteRolePermission(roleId);
		roleDao.insertRolePermission(map);
	}

}
