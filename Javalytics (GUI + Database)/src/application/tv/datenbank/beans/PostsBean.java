package application.tv.datenbank.beans;


import application.tv.model.Posts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class PostsBean {
	
	public static ObservableList<Posts> getPostsListe() {
		ObservableList<Posts> result = FXCollections.observableArrayList();
		
		Posts p1 = new Posts("Mustertext", 12345);
		Posts p2 = new Posts("Mustertext", 12345);
		Posts p3 = new Posts("Mustertext", 12345); 
		Posts p4 = new Posts("Mustertext", 12345);
		
		result.add(p1);
		result.add(p2);
		result.add(p3);
		result.add(p4);
			
		return result;
	}

}
