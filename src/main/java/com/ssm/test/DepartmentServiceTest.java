package com.ssm.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.criteria.CriteriaDepartment;
import com.ssm.dao.DepartmentDao;
import com.ssm.entity.Department;

public class DepartmentServiceTest {

	DepartmentDao departmentDao;

	void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		departmentDao = ctx.getBean(DepartmentDao.class);
	}

	@Test
	public void testCreate() {
		init();
		Department dept = new Department();
		dept.setDefaultRoleId(2);
		dept.setName("财务部");
		departmentDao.create(dept);
	}

	@Test
	public void testDeleteById() {
		init();
		departmentDao.deleteById(1);
	}

	@Test
	public void testUpdateDepartment() {
		init();
		Department dept = new Department();
		dept.setId(2);
		dept.setDefaultRoleId(2);
		dept.setName("生产部");
		dept.setUpdateBy("admin");
		dept.setUpdateTime(new Date());
        departmentDao.updateDepartment(dept);
	}

	@Test
	public void testGetAllDepartment() {
        init();
        CriteriaDepartment criteriaDepartment = new CriteriaDepartment(1);
        List<Department> departments =  departmentDao.getAllDepartment(criteriaDepartment, 3);
        System.out.println(departments);
	}

}
