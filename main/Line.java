
import java.awt.*;
import java.awt.geom.*;

public class Line implements DrawingObject {
    
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private float thickness;
    private Color color;

    public Line(double x1, double y1, double x2, double y2, float t, String color) {
        //initializes start point, end point, thickness, and color of line
        startX = x1;
        startY = y1;
        endX = x2;
        endY = y2;
        thickness = t;
        this.color = Color.decode(color);
    }

    public void draw(Graphics2D g2d) { //draws theh line using Line2D
        Line2D.Double line = new Line2D.Double(startX,startY,endX,endY);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.draw(line);
    }

}