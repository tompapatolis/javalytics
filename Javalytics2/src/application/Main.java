package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		//setUserAgentStylesheet(STYLESHEET_CASPIAN);
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Gui.fxml"));
			Scene scene = new Scene(root,800,500);			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Javalytics v1.0 - A powerful tool that converts raw data into magic");
			primaryStage.getIcons().add(new Image("/images/graph.png"));
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
		
		/*
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
		*/		
		
	}
}
