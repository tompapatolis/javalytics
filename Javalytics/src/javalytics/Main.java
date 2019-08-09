package javalytics;

public class Main {

	public static void main(String[] args) {
		System.out.println("Real-time Visitors: " + Stats.getRealTimeVisitors());
		Utils.drawLine();
		System.out.println("Total Posts: " + Stats.getTotalPosts());
		Utils.drawLine();
		System.out.println("Total Pages: " + Stats.getTotalPages());
		Utils.drawLine();
		System.out.println("Average Visitors Daily: " + Stats.getAvgVisitorsDaily());
		Utils.drawLine();
		System.out.println("Average Visitors Monthly: " + Stats.getAvgVisitorsMonthly());
		Utils.drawLine();
		System.out.println("Average Visitors Yearly: " + Stats.getAvgVisitorsYearly());
		Utils.drawLine();
		System.out.println("Growth Rate: " + Stats.getGrowthRate());
		Utils.drawLine();
		System.out.println("iOS Devices: " + Stats.getIosDevices());
		Utils.drawLine();		
		System.out.println("Total Files: " + Stats.getTotalFiles());
		Utils.drawLine();	
		System.out.println("Last Cron Execution: " + Stats.getLastCronExecution());
		Utils.drawLine();			
	}

}
