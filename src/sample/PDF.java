package sample;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PDF implements File {

    @Override
    public void open(String extensionName, String extension) {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(extensionName, extension)
        );
        fileChooser.showOpenDialog(stage);
    }
}
