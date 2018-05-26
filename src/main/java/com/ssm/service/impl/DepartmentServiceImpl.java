package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.criteria.CriteriaDepartment;
import com.ssm.dao.DepartmentDao;
import com.ssm.entity.Department;
import com.ssm.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
   
	@Autowired
	DepartmentDao departmentDao;
	
	public void create(Department dept) {
		departmentDao.create(dept);
	}

	public void deleteById(Integer id) {
		departmentDao.deleteById(id);
	}

	public void updateDepartment(Department dept) {
		departmentDao.updateDepartment(dept);
	}

	public List<Department> getAllDepartment(CriteriaDepartment criteriaDepartment, int pageSize) {
		return departmentDao.getAllDepartment(criteriaDepartment, pageSize);
	}
  
}
