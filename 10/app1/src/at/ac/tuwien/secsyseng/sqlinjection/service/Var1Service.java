package at.ac.tuwien.secsyseng.sqlinjection.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import at.ac.tuwien.secsyseng.sqlinjection.dao.Var1Dao;
import at.ac.tuwien.secsyseng.sqlinjection.exception.PasswordException;

public class Var1Service {
	
	public Var1Service () {}
	
	/**
	 * Routes Data transfer from GUI to DAO and back (resultset)
	 * @param user
	 * @param password
	 * @param secure
	 * @return
	 * @throws SQLException, PasswordException 
	 */
	public ResultSet transferVar1Response (String user, String password, boolean secure) throws SQLException, PasswordException {
		Var1Dao var1dao = new Var1Dao();
		ResultSet rs;
		
		if (secure) {
			rs = var1dao.getVar1ResponseSecure(user, password);
			password = null;
		}
		else {
			rs = var1dao.getVar1ResponseUnsecure(user, password);
			password = null;
		}
		
		return rs;
	}
}