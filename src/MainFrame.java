import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel jPanel;
    /**
     * width and height
     */
    private final int COLS = 15;
    private final int ROWS = 1;
    /**
     * the normal size of our image
     */
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
    }

    private MainFrame(){
        /**
         * init and add the panel on main frame
         */
        panelConfig();

        /**
         * init and add the main frame of our program
         */
        frameConfig();
    }

    /**
     * default init function for MainFrame
     */

    private void frameConfig(){
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Sweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * default init function for main field
     */

    private void panelConfig(){

        jPanel = new JPanel(){

            @Override
            protected void paintComponent (Graphics g){

                super.paintComponent(g);
                g.drawImage(getImage("bomb"), 0,0,this);
            }
        };


        jPanel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
        add(jPanel);
    }

    /**
     * this function returns an icon from the name in resources folder
     * @param name
     * @return
     */
    private Image getImage (String name){
        String fileName = "img/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
        return icon.getImage();
    }
}
