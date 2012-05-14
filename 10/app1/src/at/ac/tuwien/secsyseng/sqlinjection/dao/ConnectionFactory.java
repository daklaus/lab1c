/**
 * 
 */
package at.ac.tuwien.secsyseng.sqlinjection.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author klaus
 * 
 */
public class ConnectionFactory {
	// Sqlite database connection by JDBC SqLite Driver from
	// http://www.xerial.org/trac/Xerial/wiki/SQLiteJDBC

//	private static String dbFile = "database.db";
	private static String dbFile = ":memory:"; // Use in-memory database

	private static Connection _instance = null;

	private ConnectionFactory() {
	}

	public static synchronized Connection getConnection() {

		if (_instance == null) {
			try {
				System.setProperty("sqlite.purejava", "true");
				Class.forName("org.sqlite.JDBC");
				_instance = DriverManager
						.getConnection("jdbc:sqlite:" + dbFile);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return _instance;
	}

}
