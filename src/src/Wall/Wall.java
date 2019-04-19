package Wall;

import Game.driver;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Wall{

    private BufferedImage img;
    private int x,y;

    public Wall(driver game,BufferedImage img, int x, int y){


        this.img = img;
        this.x = x;
        this.y = y;

    }

    public void update(){

    }


    public void drawImage(Graphics g, ImageObserver obs){

        g.drawImage(img,x,y,obs);

    }




}
