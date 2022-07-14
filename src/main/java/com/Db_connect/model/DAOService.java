package com.Db_connect.model;

import java.sql.ResultSet;

//Abstraction
public interface DAOService {
	public void connect_Db();

	public Boolean verifyCredentials(String email, String password);

	public void saveRegistration(String name, String city, String email,String mobile);

	public ResultSet listAllReg();

	public void deleteByEmailId(String email);

	public void updateRegistration(String email, String mobile);
}
