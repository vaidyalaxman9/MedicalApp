package com.home.practice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.practice.dao.ProductDao;
import com.home.practice.pojo.Product;

@Service
public class ProductBo {

	@Autowired
	ProductDao productDao;

	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	public Product getProductData(Integer productId) {
		return productDao.getProductById(productId);
	}

	public List<Product> addProductInExistingList(List<Product> productList, int productId, String productName,
			int stockAvalability, String productDescription, String companyName, String ptName) {
		Product p = new Product(productId, productName, stockAvalability,productDescription, companyName, ptName);
		productList.add(p);
		return productList;
	}

	public List<Product> getProductData() {
		return productDao.fetchProductData();
	}

	public boolean addProduct(String productName, int stockAvalability, String productDescription, int companyId, int ptId
		) {
		int updateCount = productDao.saveProduct(productName, stockAvalability, productDescription, companyId, ptId);
		if (updateCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updateProduct(String productName, int stockAvalability, String productDescription, 
			int companyName, int ptName, int productId) {
		int updateCount = productDao.updateProduct(productName, stockAvalability, productDescription,companyName,ptName, productId);
		if (updateCount > 0) {
			return true;
		} else {
			return false;
		}
}
	public boolean deleteProduct(Integer productId) {
		int deletCount = productDao.deleteProduct(productId);
		if (deletCount > 0) {
			return true;
		} else {
			return false;
		}
}
}


