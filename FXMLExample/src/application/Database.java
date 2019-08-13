package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	
	/**
	 * @author: Tom Papatolis
	 * 
	 * A functions that returns the first column of a ResultSet as a String Array
	 * 
	 * @param query Your SQL Command
	 * @return a String Array containing values from the first column
	 */
	public static String[] getDataInArray(String query) {
		
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
	
			// Put Results into ArrayList
			ArrayList<String> column1 = new ArrayList<String>();
			//ArrayList<String> column2 = new ArrayList<String>();

			while (rs.next()) { 
				column1.add(rs.getString(1));
				//column2.add(rs.getString(2));
			}

			// Finally turn the array lists into arrays
			String[] column1Arr = new String[column1.size()];
			column1Arr = column1.toArray(column1Arr);

			/*
			String[] column2Arr = new String[column2.size()];
			column2Arr = column2.toArray(column2Arr);
			*/			
	
			con.close();
			
			System.out.println("cool");
			
			return column1Arr;			
			
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC-Driver for MySQL was not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("SQL command failed.");
			e.printStackTrace();
		}
		
		return null;
		
	}	
	
	

}
