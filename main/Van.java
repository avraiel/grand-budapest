
import java.awt.*;
import java.awt.geom.*;

public class Van implements DrawingObject {
    
    private double x;
    private double y;
    private double width;
    private double height;
    private String[] colors;

    public Van(double x, double y, double w, double h, String[] colors) {
        //initializes size, position, and colors of the Van
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        this.colors = colors;
    }

    public void draw(Graphics2D g2d) { //draws the van
        float lineThickness = ((float)height); //outline thickness
        lineThickness*=.03;

        //shadow
        Circle shadow = new Circle(x+width*.025, y+height*.828, width*.929, height*.124, colors[5]);
        shadow.draw(g2d);

        //backcar construction

            //backcar wheel

        Wheel backcar_wheel = new Wheel(x+width*.35, y+height*.68, width*.141, new String[]{colors[3],colors[4]});
        backcar_wheel.draw(g2d);

            // backcar

        Square backcar_top = new Square(x+width*.19, y+height*.12, width*.45, height*.36, colors[0]); 
        backcar_top.draw(g2d);

        Square backcar_bot = new Square(x+width*.19, y+height*.5, width*.45, height*.287, colors[1]); 
        backcar_bot.draw(g2d);

            //backcar outline

        Line backcar_outline_top = new Line(x+width*.18, y+height*.12, x+width*.65, y+height*.12, lineThickness, colors[2]);
        backcar_outline_top.draw(g2d);

        Line backcar_outline_mid = new Line(x+width*.18, y+height*.5, x+width*.65, y+height*.5, lineThickness, colors[2]);
        backcar_outline_mid.draw(g2d);

        Line backcar_outline_vertmid = new Line(x+width*.42, y+height*.5, x+width*.42, y+height*.78, lineThickness, colors[2]);
        backcar_outline_vertmid.draw(g2d);

        Line backcar_outline_bot = new Line(x+width*.18, y+height*.8, x+width*.65, y+height*.8, lineThickness, colors[2]);
        backcar_outline_bot.draw(g2d);

        Line backcar_outline_sideL = new Line(x+width*.18, y+height*.12, x+width*.18, y+height*.78, lineThickness, colors[2]);
        backcar_outline_sideL.draw(g2d);

        Line backcar_outline_sideR = new Line(x+width*.65, y+height*.12, x+width*.65, y+height*.78, lineThickness, colors[2]);
        backcar_outline_sideR.draw(g2d);

            //backcar crosses

        Line backcar_lcross1 = new Line(x+width*.19, y+height*.5, x+width*.42, y+height*.78, lineThickness, colors[2]);
        backcar_lcross1.draw(g2d);

        Line backcar_lcross2 = new Line(x+width*.42, y+height*.5, x+width*.65, y+height*.78, lineThickness, colors[2]);
        backcar_lcross2.draw(g2d);
        
        Line backcar_rcross1 = new Line(x+width*.19, y+height*.78, x+width*.42, y+height*.5, lineThickness, colors[2]);
        backcar_rcross1.draw(g2d);

        Line backcar_rcross2 = new Line(x+width*.42, y+height*.78, x+width*.65, y+height*.5, lineThickness, colors[2]);
        backcar_rcross2.draw(g2d);
        
        // frontcar construction

            //frontcar wheel
        
        Wheel frontcar_wheel = new Wheel(x+width*.861, y+height*.68, width*.141, new String[]{colors[3],colors[4]});
        frontcar_wheel.draw(g2d);

            //frontcar

        Square frontcar_top = new Square(x+width*.659, y+height*.143, width*.083, height*.362, colors[0]); 
        frontcar_top.draw(g2d);

        Triangle frontcar_window = new Triangle(x+width*.741, y+height*.143, x+width*.947, y+height*.5, x+width*.741, y+height*.5, colors[0]);
        frontcar_window.draw(g2d);

        Square frontcar_bot = new Square(x+width*.659, y+height*.5, width*.275, height*.287, colors[1]); 
        frontcar_bot.draw(g2d);

            //frontcar outline

        Line frontcar_outline_mid = new Line(x+width*.659, y+height*.5, x+width*.947, y+height*.5, lineThickness, colors[2]);
        frontcar_outline_mid.draw(g2d);

        Line frontcar_outline_bot = new Line(x+width*.659, y+height*.8, x+width*.947, y+height*.8, lineThickness, colors[2]);
        frontcar_outline_bot.draw(g2d);

        Line frontcar_outline_sideR = new Line(x+width*.94, y+height*.5, x+width*.94, y+height*.8, lineThickness, colors[2]);
        frontcar_outline_sideR.draw(g2d);

            //frontcar cross
        
        Line frontcar_lcross3 = new Line(x+width*.67, y+height*.5, x+width*.948, y+height*.8, lineThickness, colors[2]);
        frontcar_lcross3.draw(g2d);
        Line frontcar_rcross3 = new Line(x+width*.67, y+height*.8, x+width*.948, y+height*.5, lineThickness, colors[2]);
        frontcar_rcross3.draw(g2d);

        int signage_position_x = (int)(x+width*.237);
        int signage_position_y = (int)(y+height*.37);
        g2d.setFont(new Font("Arial", Font.BOLD, (int)(width*.085)));
        g2d.setColor(Color.decode(colors[3]));
        g2d.drawString("MENDL'S", signage_position_x, signage_position_y); //creates MENDL'S
        //resource for drawString: https://www.tabnine.com/code/java/methods/java.awt.Graphics2D/drawString
        // https://docs.oracle.com/javase/7/docs/api/java/awt/Font.html]
        
    }

    public void setX(double newX) {
        x = newX;
        
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}