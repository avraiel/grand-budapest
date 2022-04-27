
import java.awt.*;
import java.awt.geom.*;

public class Door implements DrawingObject {
    
    private double x;
    private double y;
    private double width;
    private String color;

    public Door(double x, double y, double w, String color) { //initializes the size, position, and colors of the Door
        this.x = x;
        this.y = y;
        width = w;
        this.color = color;
    }

    public void draw(Graphics2D g2d) { //draws the door shape
        Circle top_curve = new Circle(x,y,width,color);
        top_curve.draw(g2d); 

        Square bottom = new Square(x, y+(width/2), width, color);
        bottom.draw(g2d);
    }
}