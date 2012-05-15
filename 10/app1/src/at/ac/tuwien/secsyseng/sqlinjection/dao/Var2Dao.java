package at.ac.tuwien.secsyseng.sqlinjection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import at.ac.tuwien.secsyseng.sqlinjection.exception.PasswordException;

public class Var2Dao {

	public Var2Dao() {
	};

	/**
	 * Securly validates user credentials and search term. Returns Resultset
	 * 
	 * @param user
	 * @param password
	 * @param search
	 * @return
	 * @throws SQLException
	 * @throws PasswordException
	 */
	public ResultSet getVar2ResponseSecure(String user, String password,
			String search) throws SQLException, PasswordException {
		Connection c = ConnectionFactory.getConnection();
		String prepsearch = "%" + search + "%";
		PreparedStatement pstmt = c
				.prepareStatement("select * from account where user = ? and password = ?;");

		pstmt.setString(1, user);
		pstmt.setString(2, password);
		password = null;
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			pstmt = c
					.prepareStatement("select * from var2data where aid = ? and vz like ?;");
			pstmt.setInt(1, rs.getInt("id"));
			pstmt.setString(2, prepsearch);
			rs = pstmt.executeQuery();
			return rs;
		} else {
			throw new PasswordException(
					"Username and/or password incorrect! Are you trying something funny right here?");
		}
	}

	/**
	 * Unsecurly validates user credentials and search term. Returns Resultset
	 * 
	 * @param user
	 * @param password
	 * @param search
	 * @return
	 * @throws SQLException
	 * @throws PasswordException
	 */
	public ResultSet getVar2ResponseUnsecure(String user, String password,
			String search) throws SQLException, PasswordException {
		Connection c = ConnectionFactory.getConnection();
		String prepsearch = "%" + search + "%";
		PreparedStatement pstmt = c
				.prepareStatement("select * from account where user = ? and password = ?;");

		pstmt.setString(1, user);
		pstmt.setString(2, password);
		password = null;
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			Statement st = c.createStatement();
			rs = st.executeQuery("select * from var2data where aid = "+rs.getInt("id")+" and vz like '"+prepsearch+"';");
			return rs;
		} else {
			throw new PasswordException(
					"Username and/or password incorrect! Are you trying something funny right here?");
		}
	}
}