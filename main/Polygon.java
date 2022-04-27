
import java.awt.*;
import java.awt.geom.*;

public class Polygon implements DrawingObject {
    
    private double[] points_x;
    private double[] points_y;
    private Color color;

    public Polygon(double[] x, double[] y, String color) {
        if(x.length != y.length) {
            throw new RuntimeException("Mismatching Arrays");
        }
        points_x = x;
        points_y = y;
        this.color = Color.decode(color);
    }

    public void draw(Graphics2D g2d) {
        Path2D.Double polygon = new Path2D.Double();
        polygon.moveTo(points_x[0],points_y[0]);
        for(int i = 1; i < points_x.length; i++) {
            polygon.lineTo(points_x[i],points_y[i]);
        }
        polygon.lineTo(points_x[0],points_y[0]);
        g2d.setColor(color);
        g2d.fill(polygon);
    }

}