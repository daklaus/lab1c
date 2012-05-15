package at.ac.tuwien.secsyseng.sqlinjection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import at.ac.tuwien.secsyseng.sqlinjection.exception.PasswordException;

public class Var1Dao {
	public Var1Dao() {
	};

	/**
	 * Securly validates user credentials and returns Resultset
	 * 
	 * @param user
	 * @param password
	 * @return
	 * @throws SQLException, PasswordException 
	 */
	public ResultSet getVar1ResponseSecure(String user, String password)
			throws SQLException, PasswordException {
		Connection c = ConnectionFactory.getConnection();
		PreparedStatement pstmt = c
				.prepareStatement("select * from account where user = ? and password = ?;");

		pstmt.setString(1, user);
		pstmt.setString(2, password);
		password = null;
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			Statement st = c.createStatement();
			rs = st.executeQuery("select * from var1data;");
			return rs;
		} else {
			throw new PasswordException("Username and/or password incorrect! Are you trying something funny right here?");
		}
	}

	/**
	 * Unsecurly validates user credentials and returns Resultset
	 * 
	 * @param user
	 * @param password
	 * @return
	 * @throws SQLException, PasswordException 
	 */
	public ResultSet getVar1ResponseUnsecure(String user, String password)
			throws SQLException, PasswordException {
		Connection c = ConnectionFactory.getConnection();
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery("select * from account where user = '"
				+ user + "' and password = '" + password + "';");
		password = null;
		
		if (rs.next()) {
			st = c.createStatement();
			rs = st.executeQuery("select * from var1data;");
			return rs;
		} else {
			throw new PasswordException("Username and/or password incorrect! Are you trying something funny right here?");
		}
	}
}