package com.ssm.service;

import java.util.List;

import com.ssm.criteria.CriteriaDepartment;
import com.ssm.entity.Department;

public interface DepartmentService {
   
	 public void create(Department dept);
	 
	 public void deleteById(Integer id);
	 
	 public void updateDepartment(Department dept);
	 
	 public List<Department> getAllDepartment(CriteriaDepartment criteriaDepartment,int pageSize);
	
}
