
import java.awt.*;
import java.awt.geom.*;

public class Window implements DrawingObject {
    
    private double x;
    private double y;
    private double width;
    private double height;
    private String[] colors;
    private int window_type;

    public Window(double x, double y, double w, double h, String[] colors, int wt) {
        //initalizes size, position, colors, and window_type variable
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        this.colors = colors;
        window_type = wt;
    }

    public void draw(Graphics2D g2d) { //draws a window based on window_type
        if(window_type == 1) {

            Square window = new Square(x, y, width, width*1.48, colors[1]);
            window.draw(g2d);

            Line vertical_part = new Line(x+(width/2), y, x+(width/2), y+width, 1, colors[0]);
            vertical_part.draw(g2d);

            Line horizontal_part = new Line(x, y+width, x+width, y+width, 1, colors[0]);
            horizontal_part.draw(g2d);

        }else if(window_type == 2) {

            Circle top_curve = new Circle(x,y,width, colors[1]);
            top_curve.draw(g2d);

            Square bottom = new Square(x, y+(width/2), width, colors[1]);
            bottom.draw(g2d);

            Line vertical_part = new Line(x+(width/2), y, x+(width/2), y+(width*.97*3/2), 1, colors[0]);
            vertical_part.draw(g2d);

            Line horizontal_part = new Line(x, y+width, x+width, y+width, 1, colors[0]);
            horizontal_part.draw(g2d);

        } else if(window_type == 3) {

            Circle top_curve = new Circle(x,y,width, colors[0]);
            top_curve.draw(g2d);

            Square bottom = new Square(x, y+(width/2), width, height*.6875, colors[1]);
            bottom.draw(g2d);

            Line vertical_part = new Line(x+(width/2), y+(width/2), x+(width/2), y+height, 1, colors[0]);
            vertical_part.draw(g2d);

            Line horizontal_part = new Line(x, y+width, x+width, y+width, 1, colors[0]);
            horizontal_part.draw(g2d);
        }
    
    }

    public int getWindowType() { //used in the Floor.java class to identify which floor type is used, based on the window type
        return window_type;
    }
}