package com.home.practice.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.practice.pojo.Company;
import com.home.practice.utility.DatabaseConnection;

@Repository
public class CompanyDao {

	@Autowired
	DatabaseConnection databaseConnection;
	
	public List<Company> getCompanys() {
		List<Company> companyList = new ArrayList<Company>();
		try {
			Connection con = databaseConnection.getDatabaseConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from company");

			while (rs.next()) {
				Company c = new Company(rs.getInt("company_id"), rs.getString("company_name"),
						rs.getString("company_description"));
				companyList.add(c);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return companyList;
	}

	
	public Company getCompanyById(Integer companyId) {
		Company company = new Company();
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from company where company_id = " + companyId);

			while (rs.next()) {
				company = new Company(rs.getInt("company_id"), rs.getString("company_name"),
						rs.getString("company_description"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	return company;
	
	}
	
	public List<Company> fetchCompanyData() {
		List<Company> companyList = new ArrayList<Company>();
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from company");

			while (rs.next()) {
				Company c = new Company(rs.getInt(1), rs.getString(2), rs.getString(3));
				companyList.add(c);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return companyList;
}
	
	public int saveCompany(String companyName, String companyDescription) {
		int updateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "INSERT INTO company (company_name, company_description) values ('"
					+ companyName + "', '" + companyDescription + "')";
			updateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return updateCount;
	}
	
	public int updateCompany(String companyName,  String companyDescription, int companyId) {
		int updateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "update company set company_name = '" + companyName + "',company_description='" + companyDescription + "' where company_id = " + companyId;
			updateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);  
		}

		return updateCount;

	}
	
	public int deleteCompany(Integer companyId) {
		int udpateCount = 0;
		try {
			Connection con = databaseConnection.getDatabaseConnection();

			Statement stmt = con.createStatement();
			String query = "delete from company where company_id = " + companyId;
			udpateCount = stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return udpateCount;
	}
}