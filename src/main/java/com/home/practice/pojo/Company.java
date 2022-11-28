package com.home.practice.pojo;

public class Company {

	public int companyId;
	public String companyName;
	public String companyDescription;
		
	public Company() {
		super();
	}

	public Company(int companyId, String companyName, String companyDescription) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyDescription = companyDescription;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}
	
	
}
