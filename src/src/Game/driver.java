package Game;

import Blocks.Blocks;
import Katch.Katch;
import Katch.KatchControl;
import Star.Star;
import Wall.Wall;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class driver extends JPanel{



    public static final int SCREEN_WIDTH = 640;
    private static final int SCREEN_HEIGHT = 470;
    private BufferedImage world,bImg,katch,star1,walls,octo;
    private BufferedImage b1,b2,b3,b4,b5,b6,b7,solidB,lifeB;
    private static Katch k1;
    private Graphics2D buffer;
    private JFrame jf;
    private String line;
    private int position;
    private static Star s1;



    private ArrayList<Wall> borderWall = new ArrayList();
    private ArrayList<Blocks> blocks = new ArrayList<>();



    public static void main(String[] args) {
        Thread x;
        driver game = new driver();
        game.init();

        try {

          while (true) {

                driver.k1.update();
                driver.s1.update();
                game.checkCollisions();
                game.repaint();
                System.out.println(driver.k1);
                Thread.sleep(1000 / 144);
           }
        } catch (InterruptedException ignored) {

        }

    }


    private void init() {
        this.jf = new JFrame("Super Rainbow Reef");

        katch = null;

        this.world = new BufferedImage(driver.SCREEN_WIDTH, driver.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
        System.out.println(System.getProperty("user.dir"));



        try {
             bImg = ImageIO.read(this.getClass().getClassLoader().getResource("Background1.bmp"));
             katch = ImageIO.read(this.getClass().getClassLoader().getResource("Katch_transparent.gif"));
             walls = ImageIO.read(this.getClass().getClassLoader().getResource("Wall.gif"));
             star1 = ImageIO.read(this.getClass().getClassLoader().getResource("star.png"));


             //block images
             b1 = ImageIO.read(this.getClass().getClassLoader().getResource("Block1.gif"));
             b2 = ImageIO.read(this.getClass().getClassLoader().getResource("Block2.gif"));
             b3 = ImageIO.read(this.getClass().getClassLoader().getResource("Block3.gif"));
             b4 = ImageIO.read(this.getClass().getClassLoader().getResource("Block4.gif"));
             b5 = ImageIO.read(this.getClass().getClassLoader().getResource("Block5.gif"));
             b6 = ImageIO.read(this.getClass().getClassLoader().getResource("Block6.gif"));
             b7 = ImageIO.read(this.getClass().getClassLoader().getResource("Block7.gif"));
             solidB = ImageIO.read(this.getClass().getClassLoader().getResource("Block_solid.gif"));
             lifeB = ImageIO.read(this.getClass().getClassLoader().getResource("Block_life.gif"));



            //breakable blocks
            for(int i = 0; i < 10; i++){
                blocks.add(new Blocks(b1,120,20*i,10));
            }
            for(int i = 0; i < 10; i++){
                blocks.add(new Blocks(b2,160,20*i,10));
            }
            for(int i = 0; i < 10; i++){
                blocks.add(new Blocks(solidB,200,20*i,0));
            }
            for(int i = 0; i < 10; i++){
                blocks.add(new Blocks(b4,240,20*i,10));
            }
            for(int i = 0; i < 10; i++){
                blocks.add(new Blocks(b5,280,20*i,10));
            }
            for(int i = 0; i < 10; i++){
                blocks.add(new Blocks(solidB,320,20*i,0));
            }
            for(int i = 0; i < 10; i++){
                blocks.add(new Blocks(b6,360,20*i,10));
            }
            for(int i = 0; i < 10; i++){
                blocks.add(new Blocks(b7,400,20*i,10));
            }
            for(int i = 0; i < 10; i++){
                blocks.add(new Blocks(solidB,440,20*i,10));
            }
            for(int i = 0; i < 10; i++){
                blocks.add(new Blocks(b2,480,20*i,10));
            }

            //fixme add heart blocks and octopus




            //border wall
            for(int i = 0; i < 32; i++){
                borderWall.add(new Wall(walls,20*i,0));
            }
            for(int i = 0; i < 32; i++){
                borderWall.add(new Wall(walls,0,20*i));
            }
            for(int i = 0; i < 32; i++){
                borderWall.add(new Wall(walls,SCREEN_WIDTH - 20,20*i));
            }






        } catch (IOException e) {

        }



        k1 = new Katch(300,400,1,katch);
        KatchControl kc1 = new KatchControl(k1,KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT);

        s1 = new Star(star1,300,350);


        this.jf.setLayout(new BorderLayout());
        this.jf.add(this);

        this.jf.addKeyListener(kc1);

        this.jf.setSize(driver.SCREEN_WIDTH, driver.SCREEN_HEIGHT + 30);
        this.jf.setResizable(false);
        jf.setLocationRelativeTo(null);

        this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jf.setVisible(true);


    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        buffer = world.createGraphics();
        super.paintComponent(g2);
        drawDemo(g2);




    }

    public void drawDemo(Graphics g){

        g.drawImage(bImg,0,0,this);

        k1.drawImage(g,this);
        s1.drawImage(g,this);

        //displays breakable blocks
        for(int i = 0; i < blocks.size(); i++){
            g.drawImage(blocks.get(i).getImg(),blocks.get(i).getX(),blocks.get(i).getY(),this);
        }

        for(int i = 0;i < borderWall.size(); i++){
            g.drawImage(borderWall.get(i).getImg(),borderWall.get(i).getX(),borderWall.get(i).getY(),this);
        }




    }

    private void checkCollisions(){

        //fixme check collsions for star, blocks and walls



        //this only hits right side of the katch
        if(s1.getRect().intersects(k1.getRect())){
            s1.setVx(-1);
            s1.setVy(-1);
        }




    }




}

