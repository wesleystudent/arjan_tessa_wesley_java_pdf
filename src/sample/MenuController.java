package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.input.KeyCode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable
{
    @FXML
    private MenuBar menuBar;
    private Button brush;

    /**
     * Handle action related to "About" menu item.
     *
     * @param event Event on "About" menu item.
     */
    @FXML
    private void handleSaveAction(final ActionEvent event)
    {
        provideSaveFunctionality();
    }

    /**
     * Perform functionality associated with "Save" menu selection or CTRL-A.
     */
    private void provideSaveFunctionality()
    {
        System.out.println("You clicked on Save!");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuBar.setFocusTraversable(true);
    }
}
