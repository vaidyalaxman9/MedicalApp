package com.home.practice.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.practice.pojo.ProductType;
import com.home.practice.utility.DatabaseConnection;

@Repository
public class ProductTypeDao {

	@Autowired
	DatabaseConnection databaseConnection;

	public List<ProductType> getProductTypes() {
		List<ProductType> producttypeList = new ArrayList<ProductType>();

		try {
			Connection con = databaseConnection.getDatabaseConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from producttype");

			while (rs.next()) {
				ProductType pt = new ProductType(rs.getInt("pt_id"), rs.getString("pt_name"),
						rs.getString("pt_description"));
				producttypeList.add(pt);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return producttypeList;
	}

	public ProductType getProductTypeById(Integer ptId) {
		ProductType producttype = new ProductType();
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from producttype where pt_id = " + ptId);

			while (rs.next()) {
				producttype = new ProductType(rs.getInt("pt_id"), rs.getString("pt_name"),
						rs.getString("pt_description"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return producttype;

	}

	public List<ProductType> fetchProductTypeData() {
		List<ProductType> producttypeList = new ArrayList<ProductType>();
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from producttype");

			while (rs.next()) {
				ProductType pt = new ProductType(rs.getInt(1), rs.getString(2), rs.getString(3));
				producttypeList.add(pt);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return producttypeList;
	}
	
	public int saveProductType(String ptName, String ptDescription) {
		int updateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "INSERT INTO producttype (pt_name, pt_description) values ('"
					+ ptName + "', '" + ptDescription + "')";
			updateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return updateCount;
	}
	
	public int updateProductType(String ptName,  String ptDescription, int ptId) {
		int updateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "update producttype set pt_name = '" + ptName + "',pt_description='" + ptDescription + "' where pt_id = " + ptId;
			updateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);  
		}

		return updateCount;

	}
	
	public int deleteProductType(Integer ptId) {
		int udpateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "delete from producttype where pt_id = " + ptId;
			udpateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return udpateCount;
	}
	
}