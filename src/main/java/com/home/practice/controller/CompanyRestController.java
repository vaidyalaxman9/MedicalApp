package com.home.practice.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.practice.bo.CompanyBo;
import com.home.practice.pojo.Company;
import com.home.practice.response.StandardResponse;

@RestController
@RequestMapping("/company-service")

public class CompanyRestController {

	@Autowired
	CompanyBo companyBo;

	@GetMapping(value = "/company", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Company> getAllCompanys() {
		return companyBo.getAllCompanys();
	}
	
	@PostMapping(value = "/company", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse saveCompany(@RequestBody String companyData) {
		JSONObject companyJson = new JSONObject(companyData);
		boolean saveStatus = companyBo.addCompany(companyJson.getString("companyName"),
				companyJson.getString("companyDescription"));
		if (saveStatus)
			return new StandardResponse(true, "Company details saved successfully!");
		else
			return new StandardResponse(false, "Error while saving company details!");
	}

	@PutMapping(value = "/company", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse updateCompany(@RequestBody String companyData) {
		JSONObject companyJson = new JSONObject(companyData);
		boolean updateStatus = companyBo.updateCompany(companyJson.getString("companyName"),
				 companyJson.getString("companyDescription") , companyJson.getInt ( "companyId"));
		if (updateStatus)
			return new StandardResponse(true, "Company details updated successfully!");
		else
			return new StandardResponse(false, "Error while updating company  details!");
	}
	
	// Product Id in URL
	@DeleteMapping(value = "/company/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse deleteCompanyByUrlCompanyId(@PathVariable(value = "companyId") int companyId) {
		boolean deleteStatus = companyBo.deleteCompany(companyId);
		if (deleteStatus)
			return new StandardResponse(true, "Company details deleted successfully!");
		else
			return new StandardResponse(false, "Error while deleting company details!");
	}

}
