
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*; //used to draw basic background shapes

public class SceneCanvas extends JComponent {

    private int width;
    private int height;
    private Van mendlvan;
    private ArrayList<DrawingObject> drawings; //arraylist that points to DrawingObject elements

    public SceneCanvas(int w, int h) { // constructor set-ups the canvas' width, height, size, and drawings
        width = w;
        height = h;
        drawings = new ArrayList<DrawingObject>();
        setPreferredSize(new Dimension(width, height));
        loadDrawings(); //drawings are still instantiated in the constructor but put in another method for clarity reasons
    }

    private void loadDrawings() { //method that instatiates drawings and populates the drawings ArrayList

        //colors, done locally because not used elsewhere in the class
        String road_color = "#81778F";
        String background_color = "#9AE9FA";
        String[] fence_colors = new String[]{"#F9EFBE","#FACDB8","#EE7B7F","#EFA7A8"};
        String[] hotel_colors = new String[]{"#EE7B7F","#FACDB8","#436E80","#F9EFBE","#E16C7D","#F69D54","#FCB55F","#5088A0"};
        String[] van_colors = new String[]{"#EF9EA7", "#DC6F8C", "#5D1B26", "#BF3822", "#050A10", "#9789AA"};
       
        drawings.add(new Square(0, height*.8, width, height*.11, road_color));  //road

        for(double x = 0; x < width; x+=width*.125) //fence in lower part
            drawings.add(new Fence(x, height*.885, width*.125, height*.12, fence_colors));

        drawings.add(new Square(0,0, width, height*.8, background_color)); //background

        drawings.add(new Hotel(0,0, width, height*.8, hotel_colors)); //hotel

        //van has its own variable because it is being moved in the animation
        mendlvan = new Van(-width*.17, height*.73, width*.17, height*.136, van_colors);
        drawings.add(mendlvan);
    }

    @Override
    protected void paintComponent(Graphics g) { //overriden paintComponent method for the class
        Graphics2D g2d = (Graphics2D) g;
        
        // for antialiasing
        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        for(int i = 0; i < drawings.size(); i++) { //ArrayList drawings is subject to a loop to draw all DrawingObjects in the ArrayList
            drawings.get(i).draw(g2d);
        }

        
    }

    public Van getVan() { // gets the Mendl's Van, use this to access Van methods such as getX
        return mendlvan;
    }
    
}