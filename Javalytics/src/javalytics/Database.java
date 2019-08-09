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
			String query = "SELECT * FROM stats WHERE post_id = 1774";
			ResultSet rs = stmt.executeQuery(query);		
		
			// Print Out
			while (rs.next()) {
				System.out.println(rs.getInt(1));
			}
			
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC-Treiber for MySQL was not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("SQL command failed.");
			e.printStackTrace();
		}
		
	}

}
