package at.ac.tuwien.secsyseng.sqlinjection.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import at.ac.tuwien.secsyseng.sqlinjection.dao.Var2Dao;
import at.ac.tuwien.secsyseng.sqlinjection.exception.PasswordException;

public class Var2Service {

public Var2Service () {}
	
	/**
	 * Routes Data transfer from GUI to DAO and back (resultset)
	 * @param user
	 * @param password
	 * @param search
	 * @param secure
	 * @return
	 * @throws SQLException
	 * @throws PasswordException
	 */
	public ResultSet transferVar2Response (String user, String password, String search, boolean secure) throws SQLException, PasswordException {
		Var2Dao var2dao = new Var2Dao();
		ResultSet rs;
		
		if (secure) {
			rs = var2dao.getVar2ResponseSecure(user, password);
			password = null;
		}
		else {
			rs = var2dao.getVar2ResponseUnsecure(user, password);
			password = null;
		}
		
		return rs;
	}
}
