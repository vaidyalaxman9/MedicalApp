package com.home.practice.pojo;

public class ProductType {
	
	public int ptId;
	public String ptName;
	public String ptDescription;
		
	public ProductType() {
		super();
	}

	public ProductType(int ptId, String ptName, String ptDescription) {
		super();
		this.ptId = ptId;
		this.ptName = ptName;
		this.ptDescription = ptDescription;
	}

	public int getPtId() {
		return ptId;
	}

	public void setPtId(int ptId) {
		this.ptId = ptId;
	}

	public String getPtName() {
		return ptName;
	}

	public void setPtName(String ptName) {
		this.ptName = ptName;
	}

	public String getPtDescription() {
		return ptDescription;
	}

	public void setPtDescription(String ptDescription) {
		this.ptDescription = ptDescription;
	}
	

}
