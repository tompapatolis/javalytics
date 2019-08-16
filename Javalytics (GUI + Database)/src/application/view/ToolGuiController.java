
package application.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;

import application.tv.datenbank.beans.PostsBean;
import application.tv.model.Posts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.util.Callback;
import application.tv.datenbank.beans.LandBean;
import application.tv.model.Land;
import application.tv.util.ImageCell;
import database.Datenbankanbindungfinal;


public class ToolGuiController {
	
	@FXML
	private PieChart pieChart;

	@FXML
	private LineChart<String, Number> lineChart;

	@FXML
	private BarChart<String, Number> barChart;

	@FXML
	private TableView<Land> tvExample;

	@FXML
	private TableView<Posts> tvPosts;

	@FXML
	private ObservableList<Land> tableData;

	@FXML
	private ObservableList<Posts> tableData1;

	/**
	 * @FXML // fx:id="lb3" private Label lb1, lb2, lb3; 
	 * 
	 * @FXML 
	 *  fx:id="lbBesucherAktuell" private Label lbBesucherAktuell; 
	 * 
	 * @FXML // fx:id="lbBesucherHeute" private Label lbBesucherHeute; 
	 * 
	 * @FXML // fx:id="tfBeusucherheute" private TextField tfBesucherHeute;
	 * 
	 * @FXML // fx:id="tfBesucherAktuell" private TextField tfBesucherAktuell;
	 *       tfBesucherAktuell.getText();
	 **/
	
	@FXML
	void initialize() {
		initTableViewLand();
		initTableViewPosts();
		initPieChart();
		initLineChart();
		initBarChart();
	}

	private void initTableViewLand() {
		// Daten für die Tabelle laden
		tableData = LandBean.getLandListe();

		// Spalten erstellen
		TableColumn<Land, Image> tc1 = new TableColumn<>("Images");
		TableColumn<Land, Integer> tc2 = new TableColumn<>("Besucheranzahl");
		TableColumn<Land, String> tc3 = new TableColumn<>("Land");

		// Zuordnung Werte <-> Model
		tc1.setCellValueFactory(new PropertyValueFactory<>("flagge"));
		tc2.setCellValueFactory(new PropertyValueFactory<>("besucherAnzahl"));
		tc3.setCellValueFactory(new PropertyValueFactory<>("name"));

		// ZellenLayout setzen
		tc1.setCellFactory(new Callback<TableColumn<Land, Image>, TableCell<Land, Image>>() {

			@Override
			public TableCell<Land, Image> call(TableColumn<Land, Image> param) {
				return new ImageCell<>();
			}

		});

		// Spalten hinzufügen
		tvExample.getColumns().add(tc1);
		tvExample.getColumns().add(tc3);
		tvExample.getColumns().add(tc2);

		// Daten zuweisen
		tvExample.setItems(tableData);
	}

	private void initTableViewPosts() {
		// Daten für die Tabelle laden
		tableData1 = PostsBean.getPostsListe();

		// Spalten erstellen
		TableColumn<Posts, Integer> tc11 = new TableColumn<>("Artikelanzahl");
		TableColumn<Posts, String> tc21 = new TableColumn<>("Artikelname");

		// Zuordnung Werte <-> Model
		tc11.setCellValueFactory(new PropertyValueFactory<>("artikelAnzahl"));
		tc21.setCellValueFactory(new PropertyValueFactory<>("artikelName"));

		// Spalten hinzufügen
		tvPosts.getColumns().add(tc11);
		tvPosts.getColumns().add(tc21);

		// Daten zuweisen
		tvPosts.setItems(tableData1);
	}

	
	private void initPieChart (){
		//TODO Test
		// Anzahl aller Andriod Nutzer
		Datenbankanbindungfinal test = new Datenbankanbindungfinal();
		String andorid = test.getDataSingle("SELECT ROUND((SELECT COUNT(id) FROM stats WHERE os = 'Android'));");
		int andoridint = Integer.parseInt(andorid);
		
		// Anzahl aller IOS Nutzer
		String ios = test.getDataSingle("SELECT ROUND((SELECT COUNT(id) FROM stats WHERE os = 'IOS'));");
		int iosint = Integer.parseInt(ios);
		
		// Anzahl aller Sonstigen Betreibssysteme
		String sonstiges = test.getDataSingle("SELECT ROUND((SELECT COUNT(id) FROM stats WHERE os != 'Android' && os != 'IOS'));");
		int sonstigesint = Integer.parseInt(sonstiges);
		/**
		 * Ende Test
		 */
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		PieChart.Data slice1 = new PieChart.Data("Android Nutzer", andoridint);
		PieChart.Data slice2 = new PieChart.Data("ISO Nutzer", iosint);
		PieChart.Data slice3 = new PieChart.Data("Sonstiges", sonstigesint);

		pieChart.getData().add(slice1);
		pieChart.getData().add(slice2);
		pieChart.getData().add(slice3);
	}
	
	
	private void initLineChart (){
		
		
		// Linienchart wird initialisierung und die x-Achse und y-Achse	
		CategoryAxis x = new CategoryAxis();
		NumberAxis y = new NumberAxis();
		//TODO
		// Daten zuweisen
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM");
		//TODO
		ObservableList<Data<String, Number>> data_2 = FXCollections.observableArrayList();
		
		data_2.add(new Data(dtf.format(LocalDate.now().plusDays(-5)), 20));
		data_2.add(new Data(dtf.format(LocalDate.now().plusDays(-3)), 24));
		data_2.add(new Data(dtf.format(LocalDate.now().plusDays(-4)), 21));
		data_2.add(new Data(dtf.format(LocalDate.now().plusDays(5)), 30));
		data_2.add(new Data(dtf.format(LocalDate.now()), 25));

		SortedList<Data<String, Number>> sortedData_2 = new SortedList<>(data_2,
				(data1, data2) -> data1.getXValue().compareTo(data2.getXValue()));
		
		// Daten zuweisen
		lineChart.getData().addAll(new Series<>(sortedData_2));

		lineChart.setAnimated(false);

		x.setAutoRanging(true);
		//TODO
		ObservableList<String> cat = FXCollections.observableArrayList();

		cat.addAll(dtf.format(LocalDate.now().plusDays(-5)), dtf.format(LocalDate.now().plusDays(-2)),
				dtf.format(LocalDate.now().plusDays(-4)), dtf.format(LocalDate.now().plusDays(5)),
				dtf.format(LocalDate.now()), dtf.format(LocalDate.now().plusDays(-3)));

		SortedList<String> sortedCat = new SortedList<>(cat, (data1, data2) -> data1.compareTo(data2));
		x.setCategories(sortedCat);

		x.requestAxisLayout();

		x.tickLabelRotationProperty().set(-90);
	}
		
		
	//TODO
	private void initBarChart (){
		Datenbankanbindungfinal test = new Datenbankanbindungfinal();
		//Jahre
		String jahr2019 = test.getDataSingle("SELECT COUNT(DISTINCT ip) AS cnt FROM stats WHERE created >= ('2019-06-15 10:23:49' - INTERVAL 1 Year);");
		int jahr2019int = Integer.parseInt(jahr2019);
		String jahr2018 = test.getDataSingle("SELECT COUNT(DISTINCT ip) AS cnt FROM stats WHERE created >= ('2018-06-15 10:23:49' - INTERVAL 1 Year);");
		int jahr2018int = Integer.parseInt(jahr2018);
		
		//Monate
		String monat2019 = test.getDataSingle("SELECT COUNT(DISTINCT ip) AS cnt FROM stats WHERE created >= ('2019-06-15 10:23:49' - INTERVAL 1 month);");
		int monat2019int = Integer.parseInt(monat2019);
		String monat2018 = test.getDataSingle("SELECT COUNT(DISTINCT ip) AS cnt FROM stats WHERE created >= ('2018-06-15 10:23:49' - INTERVAL 1 month);");
		int monat2018int = Integer.parseInt(monat2018);
		
		//Tage
		String day2019 = test.getDataSingle("SELECT COUNT(DISTINCT ip) AS cnt FROM stats WHERE created >= ('2019-06-15 10:23:49' - INTERVAL 1 day);");
		int day2019int = Integer.parseInt(day2019);
		String day2018 = test.getDataSingle("SELECT COUNT(DISTINCT ip) AS cnt FROM stats WHERE created >= ('2018-06-15 10:23:49' - INTERVAL 1 day);");
		int day2018int = Integer.parseInt(day2018);
		
		XYChart.Series dataSeries1 = new XYChart.Series<>();
		dataSeries1.setName("2019");

		dataSeries1.getData().add(new XYChart.Data<String, Number>("Tag", day2019int));
		dataSeries1.getData().add(new XYChart.Data<String, Number>("Monat", monat2019int));
		dataSeries1.getData().add(new XYChart.Data<String, Number>("Jahr", jahr2019int));
		barChart.getData().add(dataSeries1);

		XYChart.Series<String, Number> dataSeries2 = new XYChart.Series<>();
		dataSeries2.setName("2018");

		dataSeries2.getData().add(new XYChart.Data<String, Number>("Tag", day2018int));
		dataSeries2.getData().add(new XYChart.Data<String, Number>("Monat", monat2018int));
		dataSeries2.getData().add(new XYChart.Data<String, Number>("Jahr", jahr2018int));
		barChart.getData().add(dataSeries2);

		assert tvExample != null : "fx:id=\"tvExample\" was not injected: check your FXML file 'Gui.fxml'.";
		assert tvPosts != null : "fx:id=\"tvPosts\" was not injected: check your FXML file 'Gui.fxml'.";

	}

	// Methode um das Fenster zu schließen
	private void setDefaultCloseOperation(int exitOnClose) {

	}

}
