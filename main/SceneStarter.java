
public class SceneStarter {
    public static void main(String[] args){ // the main method, where the java project starts
        SceneFrame sf = new SceneFrame(1024,768);
        sf.setUpGUI();
        sf.setUpKeyListener();
    }
}