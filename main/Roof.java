
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random; //resource used: https://docs.oracle.com/javase/8/docs/api/java/util/Random.html

public class Roof implements DrawingObject {
    
    private double x;
    private double y;
    private double roof_width;
    private double roof_height;
    private double frame_width;
    private double frame_height;
    private String[] colors;
    private Random randomizer;

    public Roof(double x, double y, double rw, double rh, double fw, double fh, String[] colors) {
        //initializes size, position variables, colors, and randomizer
        this.x = x;
        this.y = y;
        roof_width = rw;
        roof_height = rh;
        frame_width = fw;
        frame_height = fh;
        this.colors = colors;
        randomizer = new Random();
    }

    public void draw(Graphics2D g2d) { //draws roof
        double[] roof_points_x = new double[]{
            x+frame_width*.014,
            x+frame_width*.014+frame_width*.046,
            x+roof_width-(frame_width*.016+frame_width*.046),
            x+roof_width-frame_width*.016
        };
        double[] roof_points_y = new double[]{
            y+roof_height*.744,
            y,
            y,
            y+roof_height*.744
        };  
        Polygon roof = new Polygon(roof_points_x, roof_points_y, colors[0]);
        roof.draw(g2d);

        double[] roof_divider_points_x = new double[]{ //white portion of the roof
            x,
            x+roof_width,
            x+roof_width-frame_width*.016,
            x+frame_width*.014
        };
        double[] roof_divider_points_y = new double[]{
            y+roof_height*.744,
            y+roof_height*.744,
            y+roof_height,
            y+roof_height,
        };  
        Polygon roof_divider = new Polygon(roof_divider_points_x, roof_divider_points_y, colors[1]);
        roof_divider.draw(g2d);

        //add windows
        double put_window_y = y+roof_height*.68;

        //window creation is similar to how windows are created in Floor.java, please refer to the Floor.java file
        ArrayList<Window> windows = new ArrayList<Window>();
        double put_window_x = x+frame_width*0.0348;
        String[] window_colors = new String[]{colors[2],colors[1]};
        String[] lit_window_colors = new String[]{colors[2],colors[3]};
        String[] set_colors = window_colors;

        while(put_window_x+frame_width*.0195 < x+roof_width-frame_width*.016) { //loop to add windows to the right until no more space
            //resource used: https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
            if(randomizer.nextDouble() <= 0.3) {
                set_colors = lit_window_colors;
            }
            windows.add(new Window(put_window_x, put_window_y-frame_height*.052, frame_width*.0195, frame_height*.052,  set_colors, 3));
            put_window_x+=frame_width*.04;
            set_colors = window_colors;
        }
        for(int i = 0; i < windows.size(); i++) {
            if(i == (int)(windows.size()*0.136) || i == (int)(windows.size()*0.318) || i == (int)(windows.size()*0.727) || i == (int)(windows.size()*0.87)) {

            } else{
                windows.get(i).draw(g2d);
            }
        }

    }
}