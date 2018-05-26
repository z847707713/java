package com.ssm.criteria;

public class CriteriaDepartment {

	private String id;
	private String name;
	private Integer defaultRoleId;
	private Integer page;

	public String getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = "%" + id + "%";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = "%"+ name +"%";
	}

	public Integer getDefaultRoleId() {
		return defaultRoleId;
	}

	public void setDefaultRoleId(Integer defaultRoleId) {
		this.defaultRoleId = defaultRoleId;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public CriteriaDepartment(Integer page) {
		if (page != null) {
			this.page = page;
		} else {
			this.page = 1;
		}
	}

}
