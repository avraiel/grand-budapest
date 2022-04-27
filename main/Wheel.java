
import java.awt.*;
import java.awt.geom.*;

public class Wheel implements DrawingObject {
    
    private double x;
    private double y;
    private double size;
    private Double width;
    private Double height;
    private String[] colors;

    public Wheel(double x, double y, double size, String[] colors) {
        //initializes the size, position, and colors of the wheel
        this.x = x;
        this.y = y;
        this.size = size;
        this.colors = colors;
    }

    public void draw(Graphics2D g2d) { // draws the wheel
        Circle inner_wheel = new Circle(x+size*.18,y+size*.18, size*.63, colors[0]); 
        Circle outer_wheel = new Circle(x,y,size,colors[1]);
        outer_wheel.draw(g2d); //outer wheel drawed first so its behind the inner wheel
        inner_wheel.draw(g2d);
    }


}