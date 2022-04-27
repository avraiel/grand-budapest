
import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;


public class HotelSignage implements DrawingObject {
    
    private double x;
    private double y;
    private double width;
    private double height;
    private String[] colors;

    public HotelSignage(double x, double y, double w, double h, String[] colors) { //initializes the size, position and colors of signage
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        this.colors = colors;
    }

    public void draw(Graphics2D g2d) { //draws the signage
        Line left_post = new Line(x+width*.01, y+height*.194, x+width*.01, y+height, 2, colors[0]);
        left_post.draw(g2d);

        Line right_post = new Line(x+width, y+height*.194, x+width, y+height, 2, colors[0]);
        right_post.draw(g2d);

        Square signage_background = new Square(x+width*.01,y+height*.1,width*.99,height*.2,colors[0]);
        signage_background.draw(g2d);

        int signage_position_x = (int)(x+width*.02);
        int signage_position_y = (int)(y+height*.286);
        g2d.setFont(new Font("Arial", Font.BOLD, (int)(width*.08)));
        g2d.setColor(Color.decode(colors[1]));
        g2d.drawString("GRAND BUDAPEST HOTEL", signage_position_x, signage_position_y); // creates text
        //resource for drawString: https://www.tabnine.com/code/java/methods/java.awt.Graphics2D/drawString
        // https://docs.oracle.com/javase/7/docs/api/java/awt/Font.html]
    }
}