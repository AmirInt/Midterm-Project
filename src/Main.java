import javax.swing.*;

/**
 * Runs the programme
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            System.err.println(e);
        }
        UniversitySystem universitySystem = new UniversitySystem();
    }
}
