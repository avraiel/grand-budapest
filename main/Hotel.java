
import java.awt.*;
import java.awt.geom.*;

public class Hotel implements DrawingObject {
    
    private double x;
    private double y;
    private double width;
    private double height;
    private String[] colors;

    public Hotel(double x, double y, double w, double h, String[] colors) { //initializes the size, position and colors of hotel
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        this.colors = colors;
    }

    public void draw(Graphics2D g2d) { //draws the hotel
        
        //signage
        HotelSignage signage = new HotelSignage(x+width*.4, y+height*.187, width*.207, height*.159, new String[]{colors[2],colors[3]});
        signage.draw(g2d);

        //floors
        Floor first_floor = new Floor(x+width*.052, y+height*.765, width*.894, height*.236, width, height, new String[]{colors[0], colors[2], colors[1], colors[6]}, 1);
        first_floor.draw(g2d);
       
        Floor second_floor = new Floor(x+width*.052, y+height*.479, width*.894, height*.286, width, height, new String[]{colors[1], colors[2], colors[3], colors[6]}, 2);
        second_floor.draw(g2d);

        //base roof
        Roof base_roof = new Roof(x+width*.037, y+height*.403, width*.926, height*.077, width, height, new String[]{colors[2], colors[3], colors[7], colors[6]});
        base_roof.draw(g2d);
        
        //top floor
        Floor center_top_floor = new Floor(x+width*.333, y+height*.403, width*.334, height*.077, width, height, new String[]{colors[1], colors[2], colors[3], colors[6]}, 2);
        center_top_floor.draw(g2d);

        //top floor roof
        Roof top_floor_roof = new Roof(x+width*.317, y+height*.326, width*.365, height*.077, width, height, new String[]{colors[2], colors[3], colors[7], colors[6]});
        top_floor_roof.draw(g2d);

        //entrance
        Entrance entrance = new Entrance(x+width*.427, y+height*.726, width*.144, height*.275, new String[]{colors[3], colors[4], colors[5], colors[6]});
        entrance.draw(g2d);

        //towers
        //left tower
        Tower left_tower = new Tower(x+width*.084, y+height*.123, width*.089, height*.876, width, height, new String[]{colors[0], colors[1], colors[2], colors[3], colors[6]});
        left_tower.draw(g2d);
        //right tower
        Tower right_tower = new Tower(x+width*.826, y+height*.123, width*.089, height*.876, width, height, new String[]{colors[0], colors[1], colors[2], colors[3], colors[6]});
        right_tower.draw(g2d);
    }

}