package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datenbankanbindungfinal {
	public static String getDataSingle(String query) {
		String result = "";		
		try {			
			// Open Connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			String server 	 = "127.0.0.1";  
			int port		 = 3306; 			
			String database  = "javalytics project";
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
	
	public static int[] getDatalands(String query) {	
		int i = 0;
		
		int[] laenderArray = new int[10]; // 10 weil nur 10 Laender
		try {			
			// Open Connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			String server 	 = "127.0.0.1";  
			int port		 = 3306; 			
			String database  = "javalytics project";
			String user		 = "root";
			String passwd 	 = "";
			String con_str   = "jdbc:mysql://" + server + ":" + port + "/" + database + "?serverTimezone=UTC";
			Connection con 	 = DriverManager.getConnection(con_str, user, passwd);			
			
			// Execute Query
			Statement stmt = con.createStatement();
			ResultSet rs   = stmt.executeQuery(query);

			while(rs.next()){
				laenderArray[i] = rs.getInt(3);
				i++;
			}
			con.close();			
			
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC-Driver for MySQL was not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("SQL command failed.");
			e.printStackTrace();			
		}		
		return laenderArray;
	}

	public static String[] getDatalandsstring(String query) {	
		int i = 0;
		
		String[] laenderArray = new String[10]; // 10 weil nur 10 Laender
		try {			
			// Open Connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			String server 	 = "127.0.0.1";  
			int port		 = 3306; 			
			String database  = "javalytics project";
			String user		 = "root";
			String passwd 	 = "";
			String con_str   = "jdbc:mysql://" + server + ":" + port + "/" + database + "?serverTimezone=UTC";
			Connection con 	 = DriverManager.getConnection(con_str, user, passwd);			
			
			// Execute Query
			Statement stmt = con.createStatement();
			ResultSet rs   = stmt.executeQuery(query);

			while(rs.next()){
				laenderArray[i] = rs.getString(1);
				i++;
			}
			con.close();			
			
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC-Driver for MySQL was not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("SQL command failed.");
			e.printStackTrace();			
		}		
		return laenderArray;
	}
	
}


			
	