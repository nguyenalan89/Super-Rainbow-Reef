package Star;

import Game.driver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Star{

    private BufferedImage img;
    private int x,y;
    private int vx,vy;
    private int width, height;

    public Star(BufferedImage img,int x,int y){
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        this.vx = 1;
        this.vy = -1;

    }
    //CREDIT http://zetcode.com/tutorials/javagamestutorial/breakout/
    public void update() {

        x += vx;
        y += vy;

        if (x == 0) {
            setVx(1);
        }

        if (x == driver.SCREEN_WIDTH - 60) {
            setVx(-1);
        }

        if (y == 0) {
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
}
