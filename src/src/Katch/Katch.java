package Katch;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Katch {

    private int x,y,vx,vy;
    private BufferedImage img;
    private boolean RightPressed;
    private boolean LeftPressed;
    private int speed = 2;



    public Katch(int x, int y, int vx, int vy,BufferedImage img){

        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.img = img;
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

    public void moveLeft(){
        //fixme

    }

    public void moveRight(){


    }



    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }


    public void drawImage(Graphics g, ImageObserver obs){

        g.drawImage(img,x,y,obs);



    }


}
