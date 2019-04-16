
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;



public class driver extends JPanel  {


    public static final int SCREEN_WIDTH = 1080;
    public static final int SCREEN_HEIGHT = 720;
    private BufferedImage world,bimg;
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
        this.jf = new JFrame("Koalabr8");
        this.world = new BufferedImage(driver.SCREEN_WIDTH, driver.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
        System.out.println(System.getProperty("user.dir"));


        try {
             bimg = ImageIO.read(this.getClass().getClassLoader().getResource("Background.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }


//
//
//        TankControl tc1 = new TankControl(t1, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_ENTER);

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


        int imageWidth = this.bimg.getWidth(null);
        int imageHeight = this.bimg.getHeight(null);

        int widthX =  (driver.SCREEN_WIDTH / imageWidth);
        int heightY =  (driver.SCREEN_HEIGHT / imageHeight);


        /* nested for loop that tiles the background image starting from the top left corner and finishes at the
          end of the frame */
        for(int x = 0; x <= widthX; x++){
            for(int y = 0; y <= heightY; y++){
                g.drawImage(bimg, x * imageWidth, y * imageHeight, this);

            }
        }

    }


}

