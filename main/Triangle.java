
import java.awt.*;
import java.awt.geom.*;

public class Triangle implements DrawingObject {
    
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    private Color color;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3, String color) {
        //initializes points and color of triangle
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.color = Color.decode(color);
    }

    public void draw(Graphics2D g2d) { //draws the triangle
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(x1,y1);
        triangle.lineTo(x2,y2);
        triangle.lineTo(x3,y3);
        triangle.lineTo(x1,y1);
        g2d.setColor(color);
        g2d.fill(triangle);
    }

}