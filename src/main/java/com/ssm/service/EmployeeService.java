package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.criteria.CriteriaEmployee;
import com.ssm.entity.Employee;

public interface EmployeeService {
    
	public Employee getEmployeeById(Integer id);  	//��ѯԱ������id

	public void updateEmployee(Employee employee);	//����Ա����Ϣ
	
	public void deleteById(Integer id);
	
	public void createEmployee(Employee employee);
	
	public List<Employee> getAll(CriteriaEmployee criteriaEmployee,int pageSize);  //�õ����е�Ա����Ϣ����Ҫ�����������
	
	public void insertEmployeeAndUser(Map<Integer,Integer> map);//@param map: key(�û�id),value(Ա��id)
	
	public void deleteEmployeeAndUser(Integer id);   //ͨ��Ա��id ɾ�����������Ϣ
	
}
