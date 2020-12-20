import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Class reCAPTCHA is a copy of the reCAPTCHA system functionality
 * which extends the JLabel class and implements the performance through
 * this class
 */
public class reCAPTCHA extends JLabel {

    private ArrayList<String> reCAPTCHACodes;
    private ArrayList<String> reCAPTCHAPictures;
    private int i;
    private final int size;
    private Image background;

    /**
     * Instantiates this class
     */
    public reCAPTCHA() {
        i = 0;
        size = 5;
        background = null;
        reCAPTCHACodes = new ArrayList<>();
        reCAPTCHACodes.add("RVZSL");
        reCAPTCHACodes.add("SBAHO");
        reCAPTCHACodes.add("JNOMX");
        reCAPTCHACodes.add("KOXSK");
        reCAPTCHACodes.add("JWPXO");
        reCAPTCHAPictures = new ArrayList<>();
        reCAPTCHAPictures.add("Project Files\\reCAPTCHA\\PassImageServlet.jfif");
        reCAPTCHAPictures.add("Project Files\\reCAPTCHA\\PassImageServlet (1).jfif");
        reCAPTCHAPictures.add("Project Files\\reCAPTCHA\\PassImageServlet (2).jfif");
        reCAPTCHAPictures.add("Project Files\\reCAPTCHA\\PassImageServlet (3).jfif");
        reCAPTCHAPictures.add("Project Files\\reCAPTCHA\\PassImageServlet (4).jfif");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon(reCAPTCHAPictures.get(i));
        background = imageIcon.getImage();
        g.drawImage(background, 0, 0, null);
    }

    /**
     * Changes the index of the picture and code. In other words, it "refreshes"
     * the picture
     */
    public void refresh() {
        i = (i + 1) % size;
    }

    /**
     * @return the code for a specific picture
     */
    public String getCode() {
        return reCAPTCHACodes.get(i);
    }
}
