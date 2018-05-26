package com.ssm.dao;

import java.util.List;
import java.util.Map;

import com.ssm.criteria.CriteriaPermission;
import com.ssm.entity.Permission;

public interface PermissionDao {
   
	
	public void createPermission(Permission permission);  //����һ��Ȩ��
	
	public void updatePermission(Permission permission);   //����һ��Ȩ��
	  
	public Permission getPermissionById(Integer id);       //ͨ��ID ���Ҷ�Ӧ��Ȩ��
	
	public List<Permission> getAll(CriteriaPermission criteriaPermission,Integer pageSize);       //��ȡ���е�Ȩ��
	
	public int getAllCount(CriteriaPermission criteriaPermission,Integer pageSize);
	
	public void deletePermissionById(Integer id);    //ɾ��Ȩ�޸���id
	
	public void deleteRolePermission(Integer roleId); // ɾ���������е��ֶΣ�ͨ��id�� @param userId(�û�id)
	
	public void insertRolePermission(Map<Integer, Integer> map); // ��������в����ֶΣ�@param map: key(Ȩ��id),value(��ɫid)
	
	
	
}
