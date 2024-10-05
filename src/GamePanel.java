package src;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    private boolean rodando = false;
    private Thread threadDoJogo;

    public GamePanel() {
        init();
    }

    public synchronized void init() {
        this.rodando = true;
        threadDoJogo = new Thread(this);
        threadDoJogo.start();
    }

    @Override
    public void run() {
        while (this.rodando) {
            update();
            repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        // Update game state
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw space ship, aliens and projectiles
    }
}