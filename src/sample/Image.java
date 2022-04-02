package sample;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Image implements File{
    @Override
    public java.io.File open(String extensionName, String extension) {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(extensionName, extension)
        );
        java.io.File file = fileChooser.showOpenDialog(stage);
        return file;
    }
}
