package Wall;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Wall{

    private BufferedImage img;
    private int x,y;
    private boolean breakable;
    private int width,height;

    public Wall(BufferedImage img, int x, int y){

        this.img = img;
        this.x = x;
        this.y = y;
        this.width = img.getWidth();
        this.height = img.getHeight();
        breakable = false;

    }

   public Rectangle getRect(){

        return new Rectangle(x,y,getWidth(),getHeight());
   }





    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public BufferedImage getImg() {
        return img;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isBreakable() {
        return breakable;
    }

    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }
}
