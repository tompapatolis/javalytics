package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Label lblTest;
    
    @FXML
    void initialize() {
    	lblTest.setText("Javalytics v1.0 - Only Sex is better");
    	

    }
}
