

import java.awt.*;
import java.awt.geom.*;

public class Entrance implements DrawingObject {
    
    private double x;
    private double y;
    private double width;
    private double height;
    private String[] colors;

    public Entrance(double x, double y, double w, double h, String[] colors) {
        //initializes the size, position and colors of the Entrance
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        this.colors = colors;
    }

    public void draw(Graphics2D g2d) { //draws the entrance in its entirety
        double[] eframe_points_x = new double[]{
            x,
            x,
            x+width*.15, 
            x+width*.85,
            x+width,
            x+width
        };
        double[] eframe_points_y = new double[]{
            y+height,
            y+height*.2,
            y,
            y,
            y+height*.2,
            y+height
        };  
        Polygon entrance_frame = new Polygon(eframe_points_x, eframe_points_y, colors[1]); //draws hexagon frame!
        entrance_frame.draw(g2d);

        int signage_position_x = (int)(x+width*.04);
        int signage_position_y = (int)(y+height*.25);
        g2d.setFont(new Font("Arial", Font.BOLD, (int)(width*.1)));
        g2d.setColor(Color.decode(colors[0]));
        g2d.drawString("GRAND BUDAPEST", signage_position_x, signage_position_y); //drawString used to draw GRAND BUDAPEST, source in COA
        
        //doors below uses two door shapes to make the grand budapest door
        Door outer_door = new Door(x+width*.256, y+height*.372, width*.48, colors[2]);
        outer_door.draw(g2d);

        Door inner_door = new Door(x+width*.358, y+height*.61, width*.277, colors[3]);
        inner_door.draw(g2d);

    }
}