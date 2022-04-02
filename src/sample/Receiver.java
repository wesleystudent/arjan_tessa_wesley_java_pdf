package sample;

import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Receiver {

    public void save(){

    }

    public void open(){
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg")
                ,new FileChooser.ExtensionFilter("PDF Files", "*.pdf")
        );
        fileChooser.showOpenDialog(stage);
    }

    public void close(){

    }
}
