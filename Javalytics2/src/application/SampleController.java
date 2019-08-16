package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Label lblTest;
    
    @FXML
    private TableView<CountriesModel> tbData;
    
    @FXML
    private TableView<CountriesModel> tbData2;    
    
    @FXML
    public TableColumn<CountriesModel, Integer> studentId;

    @FXML
    public TableColumn<CountriesModel, String> firstName;

    @FXML
    public TableColumn<CountriesModel, String> lastName;    
    
    @FXML
    void initialize() {
    	lblTest.setText("Javalytics v1.0.235 beta");
    	
   	
		// Get Data for Countries
    	String[][] data = Database.getDataInArray2d("SELECT country, count(DISTINCT ip) as cnt FROM stats WHERE country <> 'Undefined' AND country <> '0' GROUP BY country ORDER BY cnt DESC");
		
        for (int i = 0; i < data.length; i++) {         	  
        	ctModels.add(new CountriesModel(i+1, data[i][0], data[i][1]));
	    }

        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        studentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        //add your data to the table here.
        tbData.setItems(ctModels);
    	
    }
    
    // Define Variables (ObservableLists) for TableViews
    private ObservableList<CountriesModel> ctModels    = FXCollections.observableArrayList();   
    private ObservableList<CountriesModel> postsModels = FXCollections.observableArrayList();
    private ObservableList<CountriesModel> pagesModels = FXCollections.observableArrayList();
    
}
