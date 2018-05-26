package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.criteria.CriteriaEmployee;
import com.ssm.entity.Employee;

public interface EmployeeService {
    
	public Employee getEmployeeById(Integer id);  	//查询员工根据id

	public void updateEmployee(Employee employee);	//更新员工信息
	
	public void deleteById(Integer id);
	
	public void createEmployee(Employee employee);
	
	public List<Employee> getAll(CriteriaEmployee criteriaEmployee,int pageSize);  //得到所有的员工信息，需要传入过滤条件
	
	public void insertEmployeeAndUser(Map<Integer,Integer> map);//@param map: key(用户id),value(员工id)
	
	public void deleteEmployeeAndUser(Integer id);   //通过员工id 删除关联表的信息
	
}
