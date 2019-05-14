package Wall;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Wall{

    private BufferedImage img;
    private int x,y;


    public Wall(BufferedImage img, int x, int y){

        this.img = img;
        this.x = x;
        this.y = y;



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




}
