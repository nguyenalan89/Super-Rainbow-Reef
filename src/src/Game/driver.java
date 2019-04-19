package Game;

import Katch.Katch;
import Katch.KatchControl;
import Wall.Wall;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class driver extends JPanel  {


    private static final int SCREEN_WIDTH = 640;
    private static final int SCREEN_HEIGHT = 480;
    private BufferedImage world,bImg,katch,wall;
    private static Katch k1;
    private Graphics2D buffer;
    private JFrame jf;
    private String line;
    private int position;
    private Wall w;

    private ArrayList<Wall> border = new ArrayList();


    public static void main(String[] args) {
        Thread x;
        driver game = new driver();
        game.init();

        try {

          while (true) {

                driver.k1.update();
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
             wall = ImageIO.read(this.getClass().getClassLoader().getResource("Wall.gif"));


            BufferedReader in = new BufferedReader(new FileReader("Layout.txt"));
            position = 0;

            while((line = in.readLine())!= null){
                for(int i = 0; i < line.length();i++){
                    if(line.charAt(i) == '1'){
                        //add to arraylist
                        //fixme position of each block
                        this.addBorder(new Wall(this,wall,position + i, 0));
                    }
                    position++;
                }


            }




        } catch (IOException e) {
            e.printStackTrace();
        }



        k1 = new Katch(300,400,0,0,katch);

        KatchControl kc1 = new KatchControl(k1,KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT);


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

        for(int i = 0; i < border.size(); i++){

            w = border.get(i);
            w.drawImage(g,this);

        }

        k1.drawImage(g,this);
    }

    public void addBorder(Wall wall){
        border.add(wall);
    }


}

