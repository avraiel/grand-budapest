
import java.awt.*;
import java.awt.geom.*;

public class Square implements DrawingObject {
    
    private double x;
    private double y;
    private double size;
    private Double width; //Double so that height and with can be compared to null
    private Double height;
    private Color color;

    //initializes size, position, and color
    public Square(double x, double y, double size, String color) { // for square
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = Color.decode(color);
    }

    public Square(double x, double y, double width, double height, String color) { //for rectangle
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.decode(color);
    }

    public void draw(Graphics2D g2d) { //draws the square
        Rectangle2D.Double square;
        if(width == null || height == null) //uses null comparison to create square or rectangle
            square = new Rectangle.Double(x,y,size,size);
        else
            square = new Rectangle.Double(x,y,width,height);
        g2d.setColor(color);
        g2d.fill(square);
    }

}