package Blocks;

import java.awt.*;
import java.awt.image.BufferedImage;



public class Blocks {

    private BufferedImage img;
    private int x,y,points;
    private boolean breakable;
    private int width,height;


    public Blocks(BufferedImage img, int x, int y, int points){
        this.img = img;
        this.x = x;
        this.y = y;
        this.points = points;
        breakable = false;
        width = img.getWidth(null);
        height = img.getHeight(null);
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BufferedImage getImg(){
        return img;
    }


    public boolean isBreakable() {
        return breakable;
    }

    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }

    public int getPoints() {
        return points;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public Rectangle getRect(){
        return new Rectangle(x,y,getWidth(),getHeight());
    }
}
