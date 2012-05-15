package at.ac.tuwien.secsyseng.sqlinjection.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import at.ac.tuwien.secsyseng.sqlinjection.exception.PasswordException;

public class Var2Dao {
	
	public Var2Dao() {
	};
	
	public ResultSet getVar2ResponseSecure(String user, String password)
			throws SQLException, PasswordException {
				return null;
		//TODO
	}
	
	public ResultSet getVar2ResponseUnsecure(String user, String password)
			throws SQLException, PasswordException {
				return null;
		//TODO
	}
}
