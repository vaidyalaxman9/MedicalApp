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

import com.home.practice.bo.ProductTypeBo;
import com.home.practice.pojo.ProductType;
import com.home.practice.response.StandardResponse;

@RestController
@RequestMapping("/producttype-service")

public class ProductTypeRestController {

	@Autowired
	ProductTypeBo producttypeBo;

	@GetMapping(value = "/producttype", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductType> getAllProductTypes() {
		return producttypeBo.getAllProductTypes();
	}
	

	@PostMapping(value = "/producttype", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse saveProductType(@RequestBody String producttypeData) {
		JSONObject producttypeJson = new JSONObject(producttypeData);
		boolean saveStatus = producttypeBo.addProductType(producttypeJson.getString("ptName"),
				producttypeJson.getString("ptDescription"));
		if (saveStatus)
			return new StandardResponse(true, "Producttype details saved successfully!");
		else
			return new StandardResponse(false, "Error while saving producttype details!");
	}
	
	@PutMapping(value = "/producttype", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse updateProductType(@RequestBody String producttypeData) {
		JSONObject producttypeJson = new JSONObject(producttypeData);
		boolean updateStatus = producttypeBo.updateProductType(producttypeJson.getString("ptName"),
				producttypeJson.getString("ptDescription") , producttypeJson.getInt ( "ptId"));
		if (updateStatus)
			return new StandardResponse(true, "ProductType details updated successfully!");
		else
			return new StandardResponse(false, "Error while updating producttype  details!");
	}
	
	// Product Id in URL
		@DeleteMapping(value = "/producttype/{ptId}", produces = MediaType.APPLICATION_JSON_VALUE)
		public StandardResponse deleteProductTypeByUrlProductTypeId(@PathVariable(value = "ptId") int ptId) {
			boolean deleteStatus = producttypeBo.deleteProductType(ptId);
			if (deleteStatus)
				return new StandardResponse(true, "ProductType details deleted successfully!");
			else
				return new StandardResponse(false, "Error while deleting producttype details!");
		}

}
