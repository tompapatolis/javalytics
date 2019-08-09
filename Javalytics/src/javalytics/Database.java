package javalytics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	public static void dbConnect() {
		
		try {
			
			// Open Connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			String server 	 = "localhost";  
			int port		 = 3306; 			
			String database  = "javalytics";
			String user		 = "root";
			String passwd 	 = "";
			String con_str   = "jdbc:mysql://" + server + ":" + port + "/" + database + "?serverTimezone=UTC";
			Connection con 	 = DriverManager.getConnection(con_str, user, passwd);			
			
			// Execute Query
			Statement stmt = con.createStatement();			
			String query   = "SELECT COUNT(distinct ip) from stats WHERE created >= (NOW() - INTERVAL 5 MINUTE)";
			ResultSet rs   = stmt.executeQuery(query);		
		
			// Output
			while (rs.next()) {
				System.out.println(rs.getInt(1)); // getType: ignore note
			}			
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC-Driver for MySQL was not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("SQL command failed.");
			e.printStackTrace();
		}
		
	}
		
	/**
	 * @author: Tom Papatolis
	 * 
	 * This function gets a single string back from the Database
	 * 
	 * @param query Your SQL Query
	 * @return Simple String from SQL Output
	 */
	public static String getDataSingle(String query) {
		String result = "";
		
		try {			
			// Open Connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			String server 	 = "localhost";  
			int port		 = 3306; 			
			String database  = "javalytics";
			String user		 = "root";
			String passwd 	 = "";
			String con_str   = "jdbc:mysql://" + server + ":" + port + "/" + database + "?serverTimezone=UTC";
			Connection con 	 = DriverManager.getConnection(con_str, user, passwd);			
			
			// Execute Query
			Statement stmt = con.createStatement();
			ResultSet rs   = stmt.executeQuery(query);
						
			rs.first();
			result = rs.getString(1);
			con.close();			
			
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC-Driver for MySQL was not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("SQL command failed.");
			e.printStackTrace();			
		}		
		return result;
		
	}
	
	
	/**
	 * @author: Tom Papatolis
	 * 
	 * This function gets a result set from the Database
	 * 
	 * @param query Your SQL Query
	 * @return Simple String from SQL Output
	 */
	public static ResultSet getData(String query) {
		ResultSet rs = null;
		
		try {			
			// Open Connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			String server 	 = "localhost";  
			int port		 = 3306; 			
			String database  = "javalytics";
			String user		 = "root";
			String passwd 	 = "";
			String con_str   = "jdbc:mysql://" + server + ":" + port + "/" + database + "?serverTimezone=UTC";
			Connection con 	 = DriverManager.getConnection(con_str, user, passwd);			
			
			// Execute Query
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);			
			con.close();			
			
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC-Driver for MySQL was not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("SQL command failed.");
			e.printStackTrace();			
		}		
		return rs;
		
	}	

}
