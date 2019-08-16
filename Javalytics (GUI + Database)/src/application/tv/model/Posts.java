package application.tv.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Posts {
	
	
	private StringProperty artikelName;
	private IntegerProperty artikelAnzahl;
	
	/**
	 * Konstruktor
	 * 
	 * @param artikelName zu setzender Artikelname
	 * @param artikelAnzahl zu setzende Artikelanzahl
	 */
	public Posts (String artikelName, Integer artikelAnzahl) {
		super();
		this.artikelName = new SimpleStringProperty();
		this.artikelAnzahl = new SimpleIntegerProperty();
		
		setName(artikelName);
		setArtikelAnzahl(artikelAnzahl);
	}
	/**
	 * Gibt den Artikelnamen als String zurück
	 * @return name des Artikels
	 */
	public String getArtikelName() {
		return artikelName.getValue();
	}

	/**
	 * Gibt die Artikelanzahl als String zurück
	 * @return Anzahl an Artikel
	 */
	public Integer getArtikelAnzahl() {
		return artikelAnzahl.getValue();
	}

	/**
	 * Setzt den Artikelnamen
	 * @param name Name des Artikels
	 */
	public void setName(String artikelName) {
		this.artikelName.setValue(artikelName);
	}

	/**
	 * Setzt die Artikelanzahl als Integerwert
	 * @param artikelAnzahl Anzahl an Artikeln
	 */
	public void setArtikelAnzahl(Integer artikelAnzahl) {
		this.artikelAnzahl.setValue(artikelAnzahl);
	}
	
}

