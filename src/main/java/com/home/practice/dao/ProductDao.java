package com.home.practice.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.home.practice.pojo.Product;
import com.home.practice.utility.DatabaseConnection;

@Repository
public class ProductDao {

	@Autowired
	DatabaseConnection databaseConnection;

	public List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<Product>();
		try {
			Connection con = databaseConnection.getDatabaseConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select d.product_id, d.product_name, d.stock_avalability, d.product_description, c.company_name, pt.pt_name from product d inner join company c on d.product_company_id= c.company_id inner join producttype pt on d.product_pt_id=pt.pt_id;");

			while (rs.next()) {
				Product p = new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("stock_avalability"),
						rs.getString("product_description"), rs.getString("company_name"), rs.getString("pt_name"));
				productList.add(p);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return productList;
	}

	public Product getProductById(Integer productId) {
		Product product = new Product();
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product where product_id = " + productId);

			while (rs.next()) {
				product = new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("stock_avalability"),
						rs.getString("product_description"),  rs.getString("product_company_id"),
						rs.getString("product_pt_id"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	return product;
	
	}
	
	public List<Product> fetchProductData() {
		List<Product> productList = new ArrayList<Product>();
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product");

			while (rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				productList.add(p);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return productList;
}
	
	public int saveProduct(String productName, int stockAvalability, String productDescription, int companyId,
			int ptId) {
		int updateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "INSERT INTO product (product_name,stock_avalability, product_description, product_company_id, product_pt_id) values ('"
					+ productName + "', '" + stockAvalability + "', '" + productDescription + "','" + companyId + "', '" + ptId + "' )";
			updateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return updateCount;
	}
	
	public int updateProduct(String productName, int stockAvalability, String productDescription, int companyId,
			int ptId, int productId) {
		int updateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "update product set product_name = '" + productName + "', stock_avalability='" + stockAvalability
					+ "',product_description='" + productDescription + "',  product_company_id = "
					+ companyId + ", product_pt_id = " + ptId +" where product_id = " + productId;
			updateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);  
		}

		return updateCount;

	}
	
	
	public int deleteProduct(Integer productId) {
		int udpateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "delete from product where product_id = " + productId;
			udpateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return udpateCount;
	}
}



