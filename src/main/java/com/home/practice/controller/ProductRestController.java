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

import com.home.practice.bo.ProductBo;
import com.home.practice.pojo.Product;
import com.home.practice.response.StandardResponse;

@RestController
@RequestMapping("/product-service")
public class ProductRestController {

	@Autowired
	ProductBo productBo;

	@GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProducts() {
		return productBo.getAllProducts();
	}

	@PostMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse saveProduct(@RequestBody String productData) {
		JSONObject productJson = new JSONObject(productData);
		boolean saveStatus = productBo.addProduct(productJson.getString("productName"),
				productJson.getInt("stockAvalability"), productJson.getString("productDescription"), productJson.getInt("companyName"),
				productJson.getInt("ptName"));
		if (saveStatus)
			return new StandardResponse(true, "Product details saved successfully!");
		else
			return new StandardResponse(false, "Error while saving product details!");
	}

	@PutMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public StandardResponse updateProduct(@RequestBody String productData) {
		JSONObject productJson = new JSONObject(productData);
		boolean updateStatus = productBo.updateProduct(productJson.getString("productName"),
				productJson.getInt("stockAvalability"), productJson.getString("productDescription"), 
				productJson.getInt("companyName"), productJson.getInt("ptName"), productJson.getInt( "productId"));
		if (updateStatus)
			return new StandardResponse(true, "Product details updated successfully!");
		else
			return new StandardResponse(false, "Error while updating product  details!");
	}
	
	// Product Id in URL
		@DeleteMapping(value = "/product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
		public StandardResponse deleteProductByUrlProductId(@PathVariable(value = "productId") int productId) {
			boolean deleteStatus = productBo.deleteProduct(productId);
			if (deleteStatus)
				return new StandardResponse(true, "Product deleted successfully!");
			else
				return new StandardResponse(false, "Error while deleting product!");
		}

		// Product Id in body
		@DeleteMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
		public StandardResponse deleteProductByBody(@RequestBody String body) {
			JSONObject productDetails = new JSONObject(body);
			boolean deleteStatus = productBo.deleteProduct(productDetails.getInt("productId"));
			if (deleteStatus)
				return new StandardResponse(true, "Product deleted successfully!");
			else
				return new StandardResponse(false, "Error while deleting product!");
		}
	}