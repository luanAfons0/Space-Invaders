package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {
    private int x, y;
    private int width = 40;
    private int height = 20;
    private int speed = 2;

    public Enemy(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
    }

    public void move() {
        x += speed;
        if (x <= 0 || x + width >= 800) {
            speed = -speed;
            y += height;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getLimites() {
        return new Rectangle(x, y, width, height);
    }
}