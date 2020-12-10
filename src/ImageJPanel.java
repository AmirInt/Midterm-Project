import javax.swing.*;
import java.awt.*;

public class ImageJPanel extends JPanel {

    private Image background;

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
