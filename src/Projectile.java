package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile {
    private int x, y;
    private int width = 50;
    private int height = 10;
    private int speed = 5;

    public Projectile(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
    }

    public void update() {
        y -= speed;
    }

    public void desenhar(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public boolean foraDaTela() {
        return y + width < 0;
    }

    public Rectangle getLimites() {
        return new Rectangle(x, y, width, height);
    }
}