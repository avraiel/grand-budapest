
import java.awt.*;
import java.awt.geom.*;

public class Tower implements DrawingObject {
    
    private double x;
    private double y;
    private double tower_width;
    private double tower_height;
    private double frame_width;
    private double frame_height;
    private String[] colors;

    public Tower(double x, double y, double tw, double th, double fw, double fh, String[] colors) {
        //initializes size, position variables, and colors
        this.x = x;
        this.y = y;
        tower_width = tw;
        tower_height = th;
        frame_width = fw;
        frame_height = fh;
        this.colors = colors;
    }

    public void draw(Graphics2D g2d) { //draws tower
        Floor first_floor = new Floor(x+tower_width*.195, y+tower_height*.733, tower_width*.608, tower_height*.267, frame_width, frame_height, new String[]{colors[0], colors[2], colors[1], colors[4]}, 1);
        first_floor.draw(g2d);

        //next 2 is for the roof
        Circle round_roof = new Circle(x+tower_width*.195, y+tower_height*.204, tower_width*.608, colors[2]);
        round_roof.draw(g2d);

        Line roof_spike = new Line(x+tower_width*.5, y, x+tower_width*.5, y+tower_height*.204, 2, colors[2]);
        roof_spike.draw(g2d);

        Floor second_floor = new Floor(x+tower_width*.195, y+tower_height*.265, tower_width*.608, tower_height*.469, frame_width, frame_height, new String[]{colors[1], colors[2], colors[3], colors[4]}, 2);
        second_floor.draw(g2d);

    }
}