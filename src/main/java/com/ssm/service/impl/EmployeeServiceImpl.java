package com.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.criteria.CriteriaEmployee;
import com.ssm.dao.EmployeeDao;
import com.ssm.entity.Employee;
import com.ssm.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
	public Employee getEmployeeById(Integer id) {
		return employeeDao.getEmployeeById(id);
	}

	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	public void deleteById(Integer id) {
		employeeDao.deleteById(id);
	}

	public void createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
	}

	public List<Employee> getAll(CriteriaEmployee criteriaEmployee, int pageSize) {
		return employeeDao.getAll(criteriaEmployee, pageSize);
	}

	public void insertEmployeeAndUser(Map<Integer, Integer> map) {
		employeeDao.insertEmployeeAndUser(map);
	}

	public void deleteEmployeeAndUser(Integer id) {
	  employeeDao.deleteEmployeeAndUser(id);
	}
   
}
