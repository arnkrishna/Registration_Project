package com.Db_connect.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Inheritance
public class DAOServiceimpl implements DAOService {
	// Encapsulation
	private Connection con;
	private Statement stmt;
	@Override
	public void connect_Db() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/login_db", "root", "Fatsoo");
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Boolean verifyCredentials(String email, String password) {
		try {
			ResultSet result = stmt
					.executeQuery("select*from login where username='" + email
							+ "' and password='" + password + "'");
			return result.next();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void saveRegistration(String name, String city, String email,String mobile) {
		try {
			 stmt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet listAllReg() {
		try {
			 ResultSet result = stmt.executeQuery("select * from registration");
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteByEmailId(String email) {
		try {
			  stmt.executeUpdate("delete from registration where email='"+email+"'");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateRegistration(String email, String mobile) {
		try {
			  stmt.executeUpdate("Update registration SET mobile='"+mobile+"' WHERE email='"+email+"'");
			

		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
