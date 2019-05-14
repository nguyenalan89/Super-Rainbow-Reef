package Star;

import Game.driver;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Star{

    private BufferedImage img;
    private int x,y;
    private int vx,vy;
    private int width, height;
    private boolean visible;
    private int lives;


    public Star(BufferedImage img,int x,int y,int lives){
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        this.vx = 1;
        this.vy = -1;
        visible = true;
        this.lives = lives;


    }

    public void update() {

        x += vx;
        y += vy;

        if (x == 20) {
            setVx(1);
        }

        if (x == driver.SCREEN_WIDTH - 60) {
            setVx(-1);
        }


        if (y == 20) {
            setVy(1);
        }


    }
    public void drawImage(Graphics g, ImageObserver obs){

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img,x,y,obs);

    }



    //for collisions
    public Rectangle getRect(){

        return new Rectangle(x,y,getWidth(),getHeight());

    }

    public BufferedImage getImg() {
        return img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public boolean isVisible() {
        return visible;
    }


    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
