package com.home.practice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.practice.dao.CompanyDao;
import com.home.practice.pojo.Company;


@Service
public class CompanyBo {

	@Autowired
	CompanyDao companyDao;
	
	public List<Company> getAllCompanys() {
		return companyDao.getCompanys();
	}
	
	public Company getCompanyData(Integer companyId) {
		return companyDao.getCompanyById(companyId);
	}
	
	public List<Company> addCompanyInExistingList(List<Company> companyList, int companyId, String companyName,
			String companyDescription) {
		Company c  = new Company(companyId, companyName, companyDescription);
		companyList.add(c);
		return companyList;
	}

	public List<Company> getCompanyData() {
		return companyDao.fetchCompanyData();
	}

	public boolean addCompany(String companyName,  String companyDescription) {
			int updateCount = companyDao.saveCompany(companyName, companyDescription);
			if (updateCount > 0) {
				return true;
			} else {
				return false;
			}
}
	public boolean updateCompany(String companyName,  String companyDescription, int companyId) {
		int updateCount = companyDao.updateCompany(companyName, companyDescription,companyId);
		if (updateCount > 0) {
			return true;
		} else {
			return false;
		}
}
	
	public boolean deleteCompany(int companyId) {
		int deletCount = companyDao.deleteCompany(companyId);
		if (deletCount > 0) {
			return true;
		} else {
			return false;
		}
}
}