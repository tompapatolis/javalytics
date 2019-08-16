package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Stats {
	
	public static String getRealTimeVisitors() {
		String query  = "SELECT COUNT(distinct ip) from stats WHERE created >= (NOW() - INTERVAL 5 MINUTE)";		
		String result = Database.getDataSingle(query);
		return result;				
	}
	
	public static int getTotalPosts() {
		return 0;		
	}	
	
	public static int getTotalPages() {
		return 0;		
	}
	
	public static int getAvgVisitorsDaily() {
		return 0;		
	}
	
	public static int getAvgVisitorsMonthly() {
		return 0;		
	}
	
	public static int getAvgVisitorsYearly() {
		return 0;		
	}	
	
	public static int getGrowthRate() {
		return 0;		
	}
	
	public static int getIosDevices() {
		return 0;		
	}
	
	public static int getTotalFiles() {
		return 800;		
	}
	
	public static String[] getCountries() {
	    String q_string = "SELECT country FROM stats GROUP BY country"; 
		String[] Countries = Database.getDataInArray(q_string);
		return Countries;
	}
	
	public static String getLastCronExecution() {		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);		
	}	
	
}

