package com.ssm.dao;

import java.util.List;
import java.util.Map;

import com.ssm.criteria.CriteriaRole;
import com.ssm.entity.Permission;
import com.ssm.entity.Role;

public interface RoleDao {

	public Role getRoleById(Integer id); // ͨ����ɫid �õ���ɫ����Ϣ(������Ȩ�޵���Ϣ)

	public void createRole(Role role); // ����һ����ɫ��@param role ��װ��ɫ����Ϣ��������Ȩ�޵���Ϣ��

	public void deleteRoleById(Integer id); // ɾ����ɫ����Ϣ ����ɾ���������� @param id

	public void updateRole(Role role); // ���½�ɫ����Ϣ
    
	public int getAllRoleCount(CriteriaRole ciCriteriaRole,Integer pageSize);
	
	public List<Role> getAllRole(CriteriaRole ciCriteriaRole,Integer pageSize); // �õ����е�role(������Ȩ��)
    
	public List<Role> getAll();
	
	public List<Role> getAllRoleAndPermissions(CriteriaRole criteriaRole,Integer pageSize); // �õ����е�role(����Ȩ��)

	public List<Permission> getRolesPermissionsById(Integer id); // ͨ����ɫid ���Ҹý�ɫ��Ӧ�����е�Ȩ��

	public void deleteUserRole(Integer userId); // ɾ���������е��ֶΣ�ͨ��id�� @param userId(�û�id)

	public void insertUserRole(Map<Integer, Integer> map); // ��������в����ֶΣ�@param map: key(��ɫid),value(�û�id)

	public void insertRolePermission(Map<Integer, Integer> map); // @param map: key(Ȩ��id)��value(��ɫid)

	public void deleteRolePermission(Integer roleId); // roleId(��ɫ)

}
