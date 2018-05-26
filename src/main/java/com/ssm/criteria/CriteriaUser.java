package com.ssm.criteria;

public class CriteriaUser {
   
	private String id;
	private String username;
	private Integer available;//0代表false ，1代表true
	private Integer page = 1;
	
	public CriteriaUser() {
		
	}
	
	
	public CriteriaUser(Integer page) {
		super();
		if(page != null) {
			this.page = page;
		} else {
			this.page = 1;
		}
		
	}


	public String getId() {
		return id;
	}
	public void setId(Integer id) {
		if(id != null) {
			this.id = "%"+id +"%";
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = "%" + username + "%";
	}
	

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}


	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}

}
