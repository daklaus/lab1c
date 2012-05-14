package at.ac.tuwien.secsyseng.sqlinjection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import at.ac.tuwien.secsyseng.sqlinjection.dao.ConnectionFactory;
import at.ac.tuwien.secsyseng.sqlinjection.gui.MainFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			initializeDb();
			
			//test(); // Later, remove this line and start GUI here
			
			MainFrame.launch();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private static void test() throws SQLException {
		Connection c = ConnectionFactory.getConnection();

		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery("select * from account;");

		while (rs.next()) {
			System.out.println(rs.getInt("id") + "|" + rs.getString("name")
					+ "|" + rs.getDouble("amount"));
		}
	}
	

	private static void initializeDb() throws SQLException {
		Connection c = ConnectionFactory.getConnection();
		Statement st = c.createStatement();
		
		// Create tables
		st.executeUpdate("create table account (" + "id integer primary key,"
				+ "name varchar(255) not null," + "amount numeric not null);");
		
		// Insert into account
		st.executeUpdate("insert into account values (0, 'christian', 10000);");
		st.executeUpdate("insert into account values (1, 'aljosha', 11000);");
		st.executeUpdate("insert into account values (2, 'johannes', 9000);");
		st.executeUpdate("insert into account values (3, 'klaus', 8000);");
	}

}
