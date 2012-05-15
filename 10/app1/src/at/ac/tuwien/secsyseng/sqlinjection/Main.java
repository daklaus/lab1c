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
			
			test(); // Later, remove this line and start GUI here
			
			MainFrame.launch();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private static void test() throws SQLException {
		Connection c = ConnectionFactory.getConnection();
		Statement st = c.createStatement();
		
		// account test
		System.out.println("============");
		System.out.println("account test");
		System.out.println("============");
		ResultSet rs = st.executeQuery("select * from account;");
		while (rs.next()) {
			System.out.println(rs.getInt("id") + "|" + rs.getString("user")
					+ "|" + rs.getString("password")+ "|" + rs.getDouble("amount"));
		}
		System.out.println("\n");
		
		// account test
		System.out.println("=============");
		System.out.println("var1data test");
		System.out.println("=============");
		rs = st.executeQuery("select * from var1data;");
		while (rs.next()) {
			System.out.println(rs.getInt("id") + "|" + rs.getString("product")
					+ "|" + rs.getString("location") + "|" + rs.getDouble("price"));
		}
	}
	

	private static void initializeDb() throws SQLException {
		Connection c = ConnectionFactory.getConnection();
		Statement st = c.createStatement();
		
		// Create table account
		st.executeUpdate("create table account (" + "id integer primary key,"
				+ "user varchar(255) not null," + "password varchar(255) not null," + "amount numeric not null);");
		
		// Create table var1data
		st.executeUpdate("create table var1data (" + "id integer primary key,"
				+ "product varchar(255) not null," + "location varchar(255) not null," + "price numeric not null);");
		
		// Insert into account
		st.executeUpdate("insert into account values (0, 'christian', 'pass1', 10000);");
		st.executeUpdate("insert into account values (1, 'aljosha', 'pass2', 11000);");
		st.executeUpdate("insert into account values (2, 'johannes', 'pass3', 9000);");
		st.executeUpdate("insert into account values (3, 'klaus', 'pass4', 8000);");
		st.executeUpdate("insert into account values (4, 'wong', 'dong', 666);");
		
		// Insert into var1data
		st.executeUpdate("insert into var1data values (0, 'Agile Custom Interceptor 7 String', 'America', 1325);");
		st.executeUpdate("insert into var1data values (1, 'Wong Dong', 'Austria - InetSec', 25);");
		st.executeUpdate("insert into var1data values (2, 'Matt Damon', 'America', 1);");
		st.executeUpdate("insert into var1data values (3, 'Fiat Stilo', 'Austria', 7000);");
	}
}