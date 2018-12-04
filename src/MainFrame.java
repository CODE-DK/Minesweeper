import javax.swing.*;
import java.awt.*;
import Sweeper.Box;
import Sweeper.Coord;
import Sweeper.Game;
import Sweeper.Ranges;

public class MainFrame extends JFrame {

    private JPanel jPanel;
    /**
     * width and height
     */
    private final int COLS = 9;
    private final int ROWS = 9;
    /**
     * the normal size of our image
     */
    private final int IMAGE_SIZE = 50;

    /**
     * number of bombs on the field
     */
    private final int BOMBS = 10;

    private Game game;

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
    }

    private MainFrame(){
//        /**
//         * this class is Singleton
//         * it creates ...
//         */
//
//        Ranges.getRanges().setSize(new Coord(COLS, ROWS));

        game = new Game(COLS, ROWS, BOMBS);
        game.start();

        /**
         * this function downloads all images to the enum Box
         * from Resources
         */
        setImages();

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




        //add exit on close to our main frame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //set title "Mine Sweeper"
        setTitle("Mine Sweeper");


        setLocationRelativeTo(null);


        setResizable(false);


        setVisible(true);

        //add icon
        setIconImage(getImage("icon"));

        pack();
    }

    /**
     * default init function for main field
     */

    private void panelConfig(){

        jPanel = new JPanel(){

            @Override
            protected void paintComponent (Graphics g){

                super.paintComponent(g);

                /**
                 * print all images from enum Box
                 */
//                for (Box box : Box.values()) {
//                    Coord coord = new Coord(box.ordinal() * IMAGE_SIZE, 0);
//                    g.drawImage((Image) box.image, coord.getX(), coord.getY(), this);
//                }

                /**
                 * new print function, works with coords that were subscrabed in Ranges
                 */

                for (Coord coord : Ranges.getRanges().getCoords()) {
                    g.drawImage(
                            (Image)game.getBox(coord).image,
                            coord.getX() * IMAGE_SIZE,
                            coord.getY() * IMAGE_SIZE,
                            this);
                }
            }
        };


        jPanel.setPreferredSize(new Dimension(
                Ranges.getRanges().getSize().getX() * IMAGE_SIZE,
                Ranges.getRanges().getSize().getY() * IMAGE_SIZE)
        );
        add(jPanel);
    }

    /**
     * this function returns an icon object with the name from resources folder
     * @param name
     * @return
     */
    private Image getImage (String name){

        String fileName = "img/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
        return icon.getImage();
    }

    /**
     * download all images by name
     */

    private void setImages(){
        for (Box box : Box.values()) {
            box.image = getImage(box.name());
        }
    }
}
