package sample.shapes;

import javafx.scene.paint.Color;
import sample.utilities.Vector;

public class Line {

    private Vector startPosition;
    private Vector endPosition;
    private Color color;
    private int width;



    public Vector getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Vector startPosition) {
        this.startPosition = startPosition;
    }

    public Vector getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Vector endPosition) {
        this.endPosition = endPosition;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Line(Vector startPosition, Vector endPosition, Color color, int width) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.color = color;
        this.width = width;
    }
}
