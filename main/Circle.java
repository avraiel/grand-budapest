
import java.awt.*;
import java.awt.geom.*;

public class Circle implements DrawingObject {
    
    private double x;
    private double y;
    private double size;
    private Double width; //Double object used for width and height so that they can be equated to null
    private Double height;
    private Color color;

    // constructor initializes the size, position, and colors 
    public Circle(double x, double y, double size, String color) { //used for circle
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = Color.decode(color);
    }

    public Circle(double x, double y, double width, double height, String color) { //used for ellipse
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.decode(color);
    }

    public void draw(Graphics2D g2d) { //draws circle/ellipse
        Ellipse2D.Double ellipse;
        if(width == null || height == null) //if statement to identify if class should draw circle or ellipse
            ellipse = new Ellipse2D.Double(x,y,size,size);
        else
            ellipse = new Ellipse2D.Double(x,y,width,height);
        g2d.setColor(color); //color
        g2d.fill(ellipse);
    }

}