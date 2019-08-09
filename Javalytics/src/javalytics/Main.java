package javalytics;

public class Main {

	public static void main(String[] args) {
		System.out.println("Real-time Visitors: " + Stats.getRealTimeVisitors());
		System.out.println("----------------------------------------------------");
		Database.dbConnect();

	}

}
