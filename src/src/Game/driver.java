package Game;

import Katch.Katch;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;




public class driver extends JPanel  {


    public static final int SCREEN_WIDTH = 640;
    public static final int SCREEN_HEIGHT = 480;
    private BufferedImage world,bImg,katch;
    private Graphics2D buffer;
    private JFrame jf;


    public static void main(String[] args) {
        Thread x;
        driver game = new driver();
        game.init();
        try {

          while (true) {

                game.repaint();
                Thread.sleep(1000 / 144);
           }
        } catch (InterruptedException ignored) {

        }

    }


    private void init() {
        this.jf = new JFrame("Super Rainbow Reef");
        this.world = new BufferedImage(driver.SCREEN_WIDTH, driver.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
        System.out.println(System.getProperty("user.dir"));



        try {
             bImg = ImageIO.read(this.getClass().getClassLoader().getResource("Background1.bmp"));
             katch = ImageIO.read(this.getClass().getClassLoader().getResource("Katch.gif"));



        } catch (IOException e) {
            e.printStackTrace();
        }
        Katch k1 = new Katch(0,0,0,0);


        this.jf.setLayout(new BorderLayout());
        this.jf.add(this);


//        this.jf.addKeyListener(tc1);


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
        g2.drawImage(world,0,0,null);

        tileBackground(g2);



    }


    public void tileBackground(Graphics2D g){


        g.drawImage(bImg,0,0,this);




    }





}

