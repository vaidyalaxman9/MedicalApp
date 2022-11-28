package com.home.practice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.practice.dao.ProductTypeDao;
import com.home.practice.pojo.ProductType;
@Service
public class ProductTypeBo {

	@Autowired
	ProductTypeDao producttypeDao;
	
	public List<ProductType> getAllProductTypes() {
		return producttypeDao.getProductTypes();
	}
	
	public ProductType getProductTypeData(Integer ptId) {
		return producttypeDao.getProductTypeById(ptId);
	}
	
	public List<ProductType> addProductTypeInExistingList(List<ProductType> producttypeList, int ptId, String ptName,
			String ptDescription) {
		ProductType pt  = new ProductType(ptId, ptName, ptDescription);
		producttypeList.add(pt);
		return producttypeList;
	}

	public List<ProductType> getProdcutTypeData() {
		return producttypeDao.fetchProductTypeData();
	}
	
	public boolean addProductType(String ptName,  String ptDescription) {
		int updateCount = producttypeDao.saveProductType(ptName, ptDescription);
		if (updateCount > 0) {
			return true;
		} else {
			return false;
		}
}
	
	public boolean updateProductType(String ptName,  String ptDescription, int ptId) {
		int updateCount = producttypeDao.updateProductType(ptName, ptDescription, ptId);
		if (updateCount > 0) {
			return true;
		} else {
			return false;
		}
}
	
	public boolean deleteProductType(int ptId) {
		int deletCount = producttypeDao.deleteProductType(ptId);
		if (deletCount > 0) {
			return true;
		} else {
			return false;
		}
}
	
}