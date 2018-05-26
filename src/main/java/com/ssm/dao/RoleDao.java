package com.ssm.dao;

import java.util.List;
import java.util.Map;

import com.ssm.criteria.CriteriaRole;
import com.ssm.entity.Permission;
import com.ssm.entity.Role;

public interface RoleDao {

	public Role getRoleById(Integer id); // 通过角色id 得到角色的信息(不包括权限的信息)

	public void createRole(Role role); // 创建一个角色，@param role 封装角色的信息（不包括权限的信息）

	public void deleteRoleById(Integer id); // 删除角色表信息 （不删除关联）， @param id

	public void updateRole(Role role); // 更新角色的信息
    
	public int getAllRoleCount(CriteriaRole ciCriteriaRole,Integer pageSize);
	
	public List<Role> getAllRole(CriteriaRole ciCriteriaRole,Integer pageSize); // 得到所有的role(不包括权限)
    
	public List<Role> getAll();
	
	public List<Role> getAllRoleAndPermissions(CriteriaRole criteriaRole,Integer pageSize); // 得到所有的role(包括权限)

	public List<Permission> getRolesPermissionsById(Integer id); // 通过角色id 查找该角色对应的所有的权限

	public void deleteUserRole(Integer userId); // 删除关联表中的字段，通过id； @param userId(用户id)

	public void insertUserRole(Map<Integer, Integer> map); // 向关联表中插入字段，@param map: key(角色id),value(用户id)

	public void insertRolePermission(Map<Integer, Integer> map); // @param map: key(权限id)，value(角色id)

	public void deleteRolePermission(Integer roleId); // roleId(角色)

}
