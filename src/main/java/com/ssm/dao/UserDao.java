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

	
	public User getUserByUserName(String username);    // ͨ���û������Ҷ�Ӧ��user��Ϣ(���˵�����Ч���û�)

	public int createUserReturnId(User user);	  // ����һ���µ�user��¼�������ض�Ӧ������
	
	public void createUser(User user);    // ֱ�Ӳ���һ���µ�user��¼
	
	public void updateUser(User user);// ����user��Ϣ

	public void deleteUser(String username);	// ͨ���û���ɾ�����û���Ϣ

	public Set<String> getRoleStrByUerName(String username);	// ͨ���û�����������û���Ӧ�����еĽ�ɫ��
	
	public Collection<String> getUsersPermissionStrByName(String username);/* ͨ���û�����
	                                                                      ������û���Ӧ������Ȩ���ַ����ļ���(���� user:create)*/
	public List<Role> getRoleByUserId(Integer id);
	
	public List<User> getAll(CriteriaUser criteriaUser,int pageSize); //�õ����е��û���Ϣ(��������ɫ��Ȩ��)
	
	public int getAllCount(CriteriaUser criteriaUser,int pageSize);
	
	public List<User> getAllUserAndRole(CriteriaUser criteriaUser,int pageSize);//�õ����е��û���Ϣ (�����û���ӵ�еĽ�ɫ)
 
	public void deleteUserRole(Integer userId); // ɾ���������е��ֶΣ�ͨ��id�� @param userId(�û�id)

	public void insertUserRole(Map<Integer, Integer> map); // ��������в����ֶΣ�@param map: key(��ɫid),value(�û�id)
	
	public List<Permission> getAllMenu();
	
}
