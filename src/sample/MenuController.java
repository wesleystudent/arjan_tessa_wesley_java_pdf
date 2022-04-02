package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import sample.shapes.Line;
import sample.utilities.Vector;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MenuController implements Initializable
{
    @FXML
    private MenuItem save;
    @FXML
    private MenuItem open;
    @FXML
    private MenuItem close;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Button  brush;
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colorPicker;

    private boolean mouseDown;
    private Vector startPos;
    private Vector endPos;
    private ArrayList<Line> graphics;
    private GraphicsContext graphicsContext;
    private ICommand saveCommand;
    private ICommand openCommand;

    public MenuController() {
        this.mouseDown = false;
        this.graphics = new ArrayList<Line>();
        this.saveCommand = new SaveCommand();
        this.openCommand = new OpenCommand();

    }

    public void refresh() {
        System.out.println("Refreshing canvas");
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

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
        this.menuBar.setFocusTraversable(true);
        this.graphicsContext = this.canvas.getGraphicsContext2D();

        canvas.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Mouse pressed.");
                startPos = new Vector(event.getX(), event.getY());
            }
        });

        canvas.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                System.out.println("Mouse dragged.");
                redrawBackground();

                for (Line line : graphics) {
                    //Draw the 'old' graphics.
                    graphicsContext.beginPath();
                    graphicsContext.setStroke(line.getColor());
                    graphicsContext.setLineWidth(line.getWidth());
                    graphicsContext.moveTo(line.getStartPosition().getX(), line.getStartPosition().getY());
                    graphicsContext.lineTo(line.getEndPosition().getX(), line.getEndPosition().getY());
                    graphicsContext.stroke();
                    graphicsContext.closePath();

                }

                //Draw the current graphic.
                graphicsContext.beginPath();
                Line line = new Line(startPos, new Vector(event.getX(), event.getY()), colorPicker.getValue(), 3);

                graphicsContext.setStroke(line.getColor());
                graphicsContext.setLineWidth(line.getWidth());
                graphicsContext.moveTo(line.getStartPosition().getX(), line.getStartPosition().getY());
                graphicsContext.lineTo(line.getEndPosition().getX(), line.getEndPosition().getY());
                graphicsContext.stroke();
                graphicsContext.closePath();
            }
        });

        canvas.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                endPos = new Vector(event.getX(), event.getY());
                Line line = new Line(startPos, endPos, colorPicker.getValue(), 3);
                graphics.add(line);
                System.out.println("mouseup");
            }

        });

        save.setOnAction(event -> {
            System.out.println("Clicked save!");
            saveCommand.execute();
        });

        open.setOnAction(event -> {
            System.out.println("Clicked open!");
            openCommand.execute();
        });
    }

    private void redrawBackground() {
        this.graphicsContext.beginPath();
        this.graphicsContext.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
        this.graphicsContext.closePath();
    }



//    this.canvas.setOnMouseClicked(event -> {
//
//    });
}
