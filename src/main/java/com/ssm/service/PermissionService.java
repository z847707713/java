package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.criteria.CriteriaPermission;
import com.ssm.entity.Permission;

public interface PermissionService {
   
public void createPermission(Permission permission);  //����һ��Ȩ��
	
	public void updatePermission(Permission permission);   //����һ��Ȩ��
	  
	public Permission getPermissionById(Integer id);       //ͨ��ID ���Ҷ�Ӧ��Ȩ��
	
	public List<Permission> getAll(CriteriaPermission criteriaPermission,int pageSize);       //��ȡ���е�Ȩ��
    
	public List<Permission> getAll();
	
	public void deletePermissionById(Integer id);    //ɾ��Ȩ�޸���id
	
	public void deleteRolePermission(Integer userId); // ɾ���������е��ֶΣ�ͨ��id�� @param userId(�û�id)

	public void insertRolePermission(Map<Integer, Integer> map); // ��������в����ֶΣ�@param map: key(��ɫid),value(�û�id)

	public int getAllCount(CriteriaPermission criteriaPermission, Integer limit);
	
	
}
