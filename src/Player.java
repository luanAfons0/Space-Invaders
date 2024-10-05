package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {
    private int x, y;
    private int width = 50;
    private int height = 20;
    private int speed = 5;

    public Player(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
    }

    public void moveLeft() {
        this.x -= this.speed;
        if (x < 0) x = 0;
    }

    public void moveRight(int larguraDaTela) {
        this.x += speed;
        if (x + width > larguraDaTela) x = larguraDaTela - width;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getLimit() {
        return new Rectangle(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}