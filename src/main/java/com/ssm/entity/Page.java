package com.ssm.entity;

import java.util.List;

public class Page<T> {
  
	int pageNo;
	List<T> list;
	int pageSize;
	long totalItemNumber;
	int totalPageNumber;
	
    public Page() {
    	
	}
    
    public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
    
    public Page(int pageSize) {
		this.pageSize = pageSize;
	}
    
    public int getPageNo() {
		return pageNo;
	}
    
    public int getPageSize() {
      return pageSize;	
    }

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
    
	public int getTotalPageNumber(){
		
		if(totalItemNumber%pageSize==0) {
			totalPageNumber = (int) (totalItemNumber / pageSize);
		} else {
			totalPageNumber = (int) (totalItemNumber / pageSize) + 1;
		}
		return totalPageNumber;
	}
	
    public void setTotalItemNumber(long totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}
	
    public boolean isHasNext() {
    	if(pageNo < getTotalPageNumber() && pageNo >=1) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
	public boolean isHasPrev() {
		if(pageNo > 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getPrevPage(){
		if(isHasPrev()) {
			return pageNo - 1;
		}
		return pageNo;
	}
	
	public int getNextPage() {
		if(isHasNext()) {
			 return pageNo + 1;	
		}
	   return pageNo;
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", list=" + list + ", pageSize=" + pageSize + ", totalItemNumber="
				+ totalItemNumber + "]";
	}
	
    
    
    
    
    
    
	
	
	
	
	
}
