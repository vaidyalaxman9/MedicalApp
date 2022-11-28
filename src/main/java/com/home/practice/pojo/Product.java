package com.home.practice.pojo;

public class Product {
	
	public int productId;
	public String productName;
	public int stockAvalability;
	public String productDescription;
	public String companyName;
	public String ptName;
	
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getStockAvalability() {
		return stockAvalability;
	}
	public void setStockAvalability(int stockAvalability) {
		this.stockAvalability = stockAvalability;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPtName() {
		return ptName;
	}
	public void setPtName(String ptName) {
		this.ptName = ptName;
	}

	public Product(int productId, String productName, int stockAvalability, String productDescription,
			String companyName, String ptName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.stockAvalability = stockAvalability;
		this.productDescription = productDescription;
		this.companyName = companyName;
		this.ptName = ptName;
	}
	

	public Product() {
		super();
	}
}