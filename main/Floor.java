
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random; // resource used: https://docs.oracle.com/javase/8/docs/api/java/util/Random.html

public class Floor implements DrawingObject {
    
    private double x;
    private double y;
    private double width;
    private double height;
    private double frame_width; //frame width and height important for scaling
    private double frame_height;
    private String[] colors;
    private int floor_number; //a specific floor has a specific type of windows
    private ArrayList<ArrayList<Window>> windows; //2d array list to better represent windows!
    private Random randomizer;

    public Floor(double x, double y, double w, double h, double fw, double fh, String[] colors, int fn) {
        //initializes the size, position variables, colors, windows, and randomizer
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        frame_width = fw;
        frame_height = fh;
        this.colors = colors;
        floor_number = fn;
        windows = new ArrayList<ArrayList<Window>>();
        randomizer = new Random();
    }

    public void draw(Graphics2D g2d) { //draws the story/floor
        //initialization stage of objects
        Square floorbackground = new Square(x, y, width, height, colors[0]); //adding flat wall
    
        // adding windows
        double put_window_y;
        if(height < (frame_height*.09)) { //windows consume a specific y-value of space, if story is smaller than the window space then,
            put_window_y = y+height;
        } else {
            put_window_y = y+frame_height*.1; 
        }

        while(put_window_y <= y+height) { // vertically goes down till no more space for windows
            String[] window_colors = new String[]{colors[1],colors[2]}; // diff window colors for unlit and lit
            String[] lit_window_colors = new String[]{colors[1],colors[3]}; 
            String[] set_colors = window_colors;

            ArrayList<Window> window_row = new ArrayList<Window>(); //row of windows
            double put_window_x = x+frame_width*.0175;
            while(put_window_x+frame_width*.02 < x+width) { //loop to go horizontally till no more space for windows

                //resource used: https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
                if(randomizer.nextDouble() <= 0.3) { // randomizes (with odds) if a window should be lit or unlit
                    set_colors = lit_window_colors;
                }
                
                //different floor types have different windows, different windows have different horizontal spaces between them
                if(floor_number == 1) { 
                    //first floor not allowed to have lit windows due to animations interfering
                    window_row.add(new Window(put_window_x, put_window_y-frame_height*.049, frame_width*.024, frame_height*.6,  window_colors, floor_number));
                    put_window_x+=frame_width*.06;
                } else if(floor_number == 2) {
                    window_row.add(new Window(put_window_x, put_window_y-frame_height*.049, frame_width*.02, frame_height*.052, set_colors, floor_number));
                    put_window_x+=frame_width*.04;
                }
                set_colors = window_colors; //resets set_colors
            }
            windows.add(window_row);
            put_window_y+=frame_height*.09; //vertical space increment
        }

        //drawing stage of objects
        floorbackground.draw(g2d);
        for(int i = 0; i < windows.size(); i++) { //loop to go through 2d array list
            for(int j = 0; j < windows.get(i).size(); j++) {
                // conditions to filter badly placed windows
                //getWindowType() is used from the Window.java class to identify which floor type it is based on the window type
                if((j == 2 || j == windows.get(i).size()-3) && windows.get(i).get(j).getWindowType() == 2) {

                } else if(j == 8 && windows.get(i).get(j).getWindowType() == 1){

                }
                else {
                    windows.get(i).get(j).draw(g2d);
                }
            }         
        }
        
        
        
        
    }
}