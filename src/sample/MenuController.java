package sample;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.Popup;
import javafx.stage.Stage;
import sample.shapes.Line;
import sample.utilities.Vector;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private MenuBar menuBar;
    @FXML
    private Button brush;
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colorPicker;


    private boolean mouseDown;
    private Vector startPos;
    private Vector endPos;
    private ArrayList<Line> graphics;
    private GraphicsContext graphicsContext;
    OpenCommand oC = new OpenCommand();

    public MenuController() {
        this.mouseDown = false;
        this.graphics = new ArrayList<Line>();

    }

    public Canvas refreshCanvas(){
        if (oC.file != null) {
            System.out.println(oC.file);
        }
        else {
            System.out.println("No file yet.");
        }
        return getCanvas();
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    @FXML
    private void newAction(ActionEvent event) {
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        graphics.clear();
    }

    @FXML
    private synchronized void openAction(ActionEvent event) {
       oC.execute();
       // When finished refresh canvas.
//        TODO: Hij refreshed meteen na de functie en wacht niet tot hij klaar is met het uitvoeren.
        refreshCanvas();
    }


    @FXML
    private void saveAction(ActionEvent event) {
        new SaveCommand().execute();
    }

    @FXML
    private void closeAction(ActionEvent event) {
        new CloseCommand().execute();
    }

    @FXML
    public void exitAction(ActionEvent event) {
        Stage stage = (Stage) canvas.getScene().getWindow();
        stage.close();
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
