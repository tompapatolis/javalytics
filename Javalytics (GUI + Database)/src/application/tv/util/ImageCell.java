package application.tv.util;

import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ImageCell<T> extends TableCell<T, Image> {

    private final ImageView image;

    public ImageCell() {
        // Fügt die Imageview als Grafik zur Darstellung zum Text zusätzlich hinzu
    	
        image = new ImageView();
        image.setFitWidth(30);
        image.setFitHeight(30);
        image.setPreserveRatio(true);
     
        setGraphic(image);
        setMinHeight(30);
        
        setText(null);
    }

    @Override
    protected void updateItem(Image item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            image.setImage(null);
        } else {
            // set image and text for non-empty cell
            image.setImage(item);
        }
    }
}