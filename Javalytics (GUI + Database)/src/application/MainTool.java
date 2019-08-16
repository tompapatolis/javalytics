package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



/**
 * JavaFX MainTool
 */

public class MainTool extends Application {
	
	// Startet das JavaFx-Programm. Irgendwann wird dann automatisch die Methode start ausgeführt
	public static void main(String[] args) {
		launch(args); 
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Oberfläche aus der FXML-Datei auslesen
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("view/ToolGui.fxml"));
	
		
		// Oberfläche auf eine Scene setzen
		Scene scene = new Scene(root);
		
		// Scene auf die Stage setzen und den Vorhang aufziehen
		primaryStage.setScene(scene);
		primaryStage.show();		
	}

}




