package com.ssm.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.criteria.CriteriaEmployee;
import com.ssm.entity.Department;
import com.ssm.entity.Employee;
import com.ssm.service.EmployeeService;

public class EmployeeServiceTest {
   
	EmployeeService employeeService;
	
	void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		employeeService = ctx.getBean(EmployeeService.class);
	}
	
	@Test
	public void testGetEmployeeById() {
		init();
	 	Employee employee = employeeService.getEmployeeById(1);
		System.out.println(employee);
		
	}

	@Test
	public void testUpdateEmployee() {
		init();
		Employee employee = new Employee();
		employee.setId(1);
		Department department = new Department();
		department.setId(1);
		employee.setDepartment(department);
		employee.setEmail("847707712@qq.com");
	    employee.setIdCard("320324199509254196");
	    employee.setType("type");
	    employee.setUpdateBy("admin");
	    employee.setUpdateTime(new Date());
	    employeeService.updateEmployee(employee);
	    
	}

	@Test
	public void testDeleteById() {
		init();
		employeeService.deleteById(1);
	}

	@Test
	public void testCreateEmployee() {
		init();
		Date date = new Date();
		Employee employee = new Employee();
		employee.setId(1);
		Department department = new Department();
		department.setId(1);
		employee.setDepartment(department);
		employee.setEmail("847707712@qq.com");
	    employee.setIdCard("320324199509254196");
	    employee.setType("type");
	    employee.setName("zhanghao");
	    employee.setUpdateBy("admin");
	    employee.setUpdateTime(date);
	    employee.setCreateTime(date);
	    employee.setCreateBy("admin");
	    employeeService.createEmployee(employee);
	    
	}

	@Test
	public void testGetAll() {
		init();
		CriteriaEmployee criteriaEmployee = new CriteriaEmployee(1);
	 	//criteriaEmployee.setId(1);
	    
		List<Employee> employees = employeeService.getAll(criteriaEmployee, 3);
		
	}

	@Test
	public void testInsertEmployeeAndUser() {
	   init();
	   Map<Integer,Integer> map = new HashMap<Integer, Integer>(); //(key代表userId),(value代表employeeId) 
	   map.put(1,1);
	   map.put(2,1);
	   map.put(3,1);
	   employeeService.insertEmployeeAndUser(map);
	}

	@Test
	public void testDeleteEmployeeAndUser() {
		init();
		employeeService.deleteEmployeeAndUser(1);
	}

}
