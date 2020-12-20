import javax.swing.*;
import java.awt.*;

/**
 * Class ImageJPanel extends the JPanel class and is used to create
 * JPanels with background images
 * @author AmirFazlollahi
 * @since the dawn of time
 * @version -1
 */
public class ImageJPanel extends JPanel {

    private Image background;

    /**
     * Instantiates this class
     * @param imageURL The URL of the image file to be set for the background
     */
    public ImageJPanel(String imageURL) {
        ImageIcon imgIcon = new ImageIcon(imageURL);
        background = imgIcon.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(background != null) {
            g.drawImage(background, 0, 0, null);
        }
    }
}
