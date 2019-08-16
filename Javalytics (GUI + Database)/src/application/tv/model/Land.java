package application.tv.model;



import database.Datenbankanbindungfinal;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class Land {
	
	private ObjectProperty<Image> flagge;
	private StringProperty name;
	private IntegerProperty besucherAnzahl;
	
	/**
	 * Konstruktor
	 * 
	 * @param name zu setzender Ländername 
	 * @param besucherAnzahl zu setzende Besucheranzahl
	 * @param dateiname zu setzende Länderflagge
	 * name als String-Wert
	 * besucherAnzahl aks Integer-Wert
	 * dateinma als String-Wert
	 */
	public Land (String name, Integer besucherAnzahl, String dateiname) {
		//verweist auf die Vererbung hin 
		super();
		this.name = new SimpleStringProperty();
		this.besucherAnzahl = new SimpleIntegerProperty();
		this.flagge = new SimpleObjectProperty<>();
		/**
		 * Setzt den Ländernamen, gibt die Besucheranzahl zurück und setzt die jeweiligeFlagge nach dem Landesnamen
		 * @param name Name des Landes
		 * @param besucherAnzahl die Anzahl an Besuchern
		 * @param dateiname 
		 */
		setName(name);
		getBesucherAnzahl(besucherAnzahl);
		setFlagge(dateiname);
	}
	//Setzt das Image aus dem relativen Pfad 
	private void setFlagge(String name) {
		Image img = new Image(this.getClass().getResourceAsStream("../../res/" + name + ".png"));
		flagge.setValue(img);
	}
	/**
	 * Gibt das Image (Flagge) zurück
	 * @return flagge
	 */
	public Image getFlagge() {
		return flagge.getValue();
	}

	/**
	 * Gibt den Ländernamen als String zurück
	 * @return name des Landes
	 */
	public String getName() {
		return name.getValue();
	}

	/**
	 * Gibt die Besucheranzahl als String zurück
	 * @return Anzahl an Besucher
	 */
	public Integer getBesucherAnzahl() {
		return besucherAnzahl.getValue();
	}

	/**
	 * Setzt den Ländernamen
	 * @param name Name des Landes
	 */
	public void setName(String name) {
		this.name.setValue(name);
	}

	/**
	 * Setzt die Besucheranzahl als Integerwert
	 * @param besucherAnzahl Anzahl an Besuchern
	 */
	public void getBesucherAnzahl(Integer besucherAnzahl) {
		this.besucherAnzahl.setValue(besucherAnzahl);
	}
	
}

