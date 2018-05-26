package com.ssm.criteria;

import java.util.Date;

import com.ssm.entity.Department;

public class CriteriaEmployee {

	private String id;
	private String name;
	private String idCard;
	private String email;
	private String type;
	private Department department;
	private Integer page;
	
	public String getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = "%"+ id +"%";
	}

	public String getName() {
		return "%"+ name + "%";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = "%" + idCard + "%";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = "%" + email + "%";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public CriteriaEmployee(Integer page) {
		if(page != null) {
			this.page = page; 
		} else {
			this.page = 1;
		}
	}
	
	public CriteriaEmployee() {
		
	}

}
