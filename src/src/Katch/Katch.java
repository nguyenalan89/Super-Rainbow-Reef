package Katch;

import Game.driver;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Katch {

    private int x,y;
    private int vx;
    private BufferedImage img;
    private boolean RightPressed;
    private boolean LeftPressed;
    private int width,height;



    public Katch(int x, int y,int vx,BufferedImage img){

        this.x = x;
        this.y = y;
        this.vx = vx;
        this.img = img;
        this.width = img.getWidth();
        this.height = img.getHeight();
    }

    void toggleRightPressed() {
        this.RightPressed = true;
    }

    void toggleLeftPressed() {
        this.LeftPressed = true;
    }

    void unToggleRightPressed() {
        this.RightPressed = false;
    }

    void unToggleLeftPressed() {
        this.LeftPressed = false;
    }


    public void update(){


        if (this.LeftPressed) {
           this.moveLeft();

        }
        if (this.RightPressed) {
          this.moveRight();
        }



    }

    public void moveRight() {

        x -= vx;
        checkBorder();

    }
    public void moveLeft(){

        x+=vx;
        checkBorder();

    }

    public void checkBorder(){
        if (x < 20) {
            x = 20;
        }
        if (x >= driver.SCREEN_WIDTH - 100) {
            x = driver.SCREEN_WIDTH - 100;
        }

    }


    @Override
    public String toString() {
        return "x =" + x;
    }


    public void drawImage(Graphics g, ImageObserver obs){

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img,x,y,obs);



    }

    public Rectangle getRect(){

        return new Rectangle(x,y,getWidth(),getHeight());
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
