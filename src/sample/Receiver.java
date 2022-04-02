package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;


public class Receiver {
    public File file = null;

    public void save(){

    }

    public File open(){
        Stage popup = new Stage();
        popup.setTitle("Soort file");
        Button pdf = new Button("Open PDF");
        Button img = new Button("Open Image");
        Button blanco = new Button("Open Empty Canvas");

        pdf.setStyle("-fx-max-width: 300;");
        img.setStyle("-fx-max-width: 300;");
        blanco.setStyle("-fx-max-width: 300;");

        VBox vBox = new VBox();
        vBox.getChildren().add(pdf);
        vBox.getChildren().add(img);
        vBox.getChildren().add(blanco);
        vBox.setStyle("-fx-padding: 100");

        Scene scene = new Scene(vBox, 500.0, 250.0);
        popup.setScene(scene);
        popup.show();

        pdf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               file = new PDF().open(new Facade("PDF").extensionName, new Facade("PDF").extension);
               popup.hide();
            }
        });

        img.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                file = new Image().open(new Facade("Image").extensionName, new Facade("Image").extension);
                popup.hide();
            }
        });

        blanco.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                file = new Blanco().open(new Facade("Blanco").extensionName, new Facade("Blanco").extension);
                popup.hide();
            }
        });
        return file;
    }

    public void close(){

    }
}
