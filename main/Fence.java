

import java.awt.*;
import java.awt.geom.*;

public class Fence implements DrawingObject {
    
    private double x;
    private double y;
    private double width;
    private double height;
    private String[] colors;

    public Fence(double x, double y, double w, double h, String[] colors) {
        //initializes the size, position and colors of the fence
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        this.colors = colors;
    }

    public void draw(Graphics2D g2d) { //draws the fence
        float lineThickness = ((float)height);
        lineThickness*=.02;

        Line top_rail = new Line(x, y, x+width, y, lineThickness, colors[0]);
        top_rail.draw(g2d);

        Square divider = new Square(x, y+height*.02, height*.17, colors[3]); 
        divider.draw(g2d);

        for(double i = x+width*.13; i <= x+width; i+=width*.02) {
            Line fence_railing = new Line(i, y+height*.02, i, y+height*.19, lineThickness, colors[0]);
            fence_railing.draw(g2d);
        }

        Line bot_rail = new Line(x, y+height*.2, x+width, y+height*.2, lineThickness, colors[0]);
        bot_rail.draw(g2d);

        Square bigwall = new Square(x+width*.12, y+height*.22, width*.88, height*.67, colors[1]);
        bigwall.draw(g2d);

        Square inner_wall = new Square(x+width*.22, y+height*.28, width*.68, height*.53, colors[2]);
        inner_wall.draw(g2d);

        Square innermost_wall = new Square(x+width*.242, y+height*.318, width*.63, height*.46, colors[3]);
        innermost_wall.draw(g2d);

        Square divider_pillar = new Square(x, y+height*.2159, width*.117, height*.78, colors[0]);
        divider_pillar.draw(g2d);

        Square bottom_fence = new Square(x+width*.12, y+height*.89, width*.88, height*.114, colors[0]);
        bottom_fence.draw(g2d);
    }

}