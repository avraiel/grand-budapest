

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //used for KeyListener
import java.util.Timer; //Timer and TimerTask used for continuous animation
import java.util.TimerTask;
// resources used: https://stackoverflow.com/questions/30718356/java-swing-timer-loop-slows-down,
// https://www.geeksforgeeks.org/java-util-timer-class-java/, https://docs.oracle.com/javase/7/docs/api/java/util/Timer.html
import java.io.File;
import javax.sound.sampled.AudioSystem;

public class SceneFrame {
    private int width;
    private int height;
    private JFrame frame;
    private SceneCanvas sceneCanvas;
    private Timer timer;
    private boolean vanRunning;
    
    public SceneFrame(int w, int h) { //class's constructor, initializes the values for the declared fields above
        width = w;
        height = h;
        frame = new JFrame();
        sceneCanvas = new SceneCanvas(width, height);
        timer = new Timer();
        vanRunning = false;
    }

    public void setUpGUI() { //set-ups my JFrame's GUI
        frame.setTitle("Midterm Project - Geraldo, Gabriel - 212734");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); //setting the JFrame to be not resizable is a personal preference
        //resource for resizable: https://stackoverflow.com/questions/18031704/jframe-how-to-disable-window-resizing
        frame.add(sceneCanvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void startVanLoop() { // method to get the van moving. starts left to right, then loops back, then goes left to right again.
        TimerTask vanLoop = new TimerTask() { //we define a class here that extends TimerTask, this class is the daemon that the Timer class loops
        //you probs already know what daemon means but daemon means code that is running continuously
            double x_increment = width*0.0097; 
            Van mendlVan = sceneCanvas.getVan();

            public void run() {
                mendlVan.setX(mendlVan.getX()+x_increment); //increments van's x-value

                if(mendlVan.getX() >= width) {
                    mendlVan.setX(-width*.17); //goes back to beginning if past frame's width
                }

                //repaint is only done in a specific area to not get in the way of the window light animation
                sceneCanvas.repaint((int)(mendlVan.getX()-width*.005), (int)mendlVan.getY(), (int)(width*.3), (int)(height*.136));
                //resource used: https://docs.oracle.com/javase/7/docs/api/javax/swing/JComponent.html
            }
        };
        timer = new Timer(); //still need to make new instance even if initialized to restart loop
        timer.scheduleAtFixedRate(vanLoop, 0, 100); //how the loop is started, vanLoop repeated every 100ms by Timer method
    }

    public void setUpKeyListener()  { //the KeyListener for the project
        //resource for KeyListener: https://docs.oracle.com/javase/tutorial/uiswing/events/keylistener.html
        KeyListener kl = new KeyListener(){ //defined class that extends KeyListener, used to listen to keys to trigger animations.
            
            @Override
            public void keyPressed(KeyEvent e){
                
                if(e.getKeyChar() == ' ') { //spacebar is used as a toggle to stop and start the van
                    if(vanRunning == true){
                        timer.cancel(); //stop van
                        vanRunning = false; 
                    }
                    else {
                        startVanLoop(); //start van
                        vanRunning = true;
                    }         
                }
                if(e.getKeyChar() == 'r') { //'r' key is used to reload the animation of the lights in the hotel
                    sceneCanvas.repaint(0, 0, (int)width, (int)(height*.7)); //repaint only done to area not including the van
                    //resource used: https://docs.oracle.com/javase/7/docs/api/javax/swing/JComponent.html
                }
            }
            // methods below left blank because no uses for them
            @Override
            public void keyReleased(KeyEvent e) {
            
            }
            @Override
            public void keyTyped(KeyEvent e) {
                
            } 
        };
        //added KeyListener to frame
        frame.addKeyListener(kl);
        
    }

}