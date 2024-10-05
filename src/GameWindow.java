package src;
import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public GameWindow() {
        this.setTitle("Space Invaders!");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.add(new GamePanel());
        this.setVisible(true);
    }
}