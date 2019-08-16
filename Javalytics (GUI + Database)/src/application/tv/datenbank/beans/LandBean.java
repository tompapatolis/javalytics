package application.tv.datenbank.beans;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import application.tv.model.Land;
import database.Datenbankanbindungfinal;

/**
 * @param pulic class LandBean ObservableList
 */

public class LandBean {	
	// LandListe wird an das Interface ObservableList übergeben

	public static ObservableList<Land> getLandListe() {
		ObservableList<Land> result = FXCollections.observableArrayList();
		
		/**
		 * Setzt den Ländernamen, gibt die Besucheranzahl zurück und setzt die
		 * jeweiligeFlagge nach dem Landesnamen Land = erstellt ein neues Object Land
		 * 
		 * @param besucherAnzahl die Anzahl an Besuchern
		 * @param dateiname      Flaggenreferenz über den Ländernamen
		 * @param name           Ländername
		 */
		


		// Anzahl aller Länder mit den höchsten zu erst begrenzt auf 10
		Datenbankanbindungfinal dbVlander = new Datenbankanbindungfinal();
		int[] landerint = new int[0];
		landerint = dbVlander.getDatalands("SELECT country, country_code, count(DISTINCT ip) as cnt FROM stats WHERE country != 'Undefined' AND country != '0' GROUP BY country ORDER BY cnt DESC LIMIT 10;");

		String[] landerString = new String[0];
		landerString = dbVlander.getDatalandsstring("SELECT country, country_code, count(DISTINCT ip) as cnt FROM stats WHERE country != 'Undefined' AND country != '0' GROUP BY country ORDER BY cnt DESC LIMIT 10;");
		for(int i = 0; i < 10; i ++) {
			System.out.println(landerString[i]);
		}
		
		Land fr = new Land(landerString[0], landerint[0], landerString[0]);
		Land us = new Land(landerString[1], landerint[1], landerString[1]); 
		Land ge = new Land(landerString[2], landerint[2], landerString[2]); 
		Land ru = new Land(landerString[3], landerint[3], landerString[3]);
		Land gr = new Land(landerString[4], landerint[4], landerString[4]);
		Land nl = new Land(landerString[5], landerint[5], landerString[5]);
		Land cn = new Land(landerString[6], landerint[6], landerString[6]);
		Land fi = new Land(landerString[7], landerint[7], landerString[7]); 
		Land ua = new Land(landerString[8], landerint[8], landerString[8]);
		Land en = new Land(landerString[9], landerint[9], landerString[9]);

		// Übergibt das Result (Ergebnis) an die  Variable
		result.add(fr);
		result.add(us);
		result.add(ge);
		result.add(ru);
		result.add(nl);
		result.add(gr);
		result.add(cn);
		result.add(fi);
		result.add(ua);
		result.add(en);

		return result;
	}

}
