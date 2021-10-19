package engine;

import com.company.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameWindow {

    private static final int SLEEP = 25;

    private boolean playing = true;
    private JPanel panel;
    private BufferedImage bufferedImage; // image sur laquelle on va dessiner nos entite dessus
    private Graphics2D buffer;
    private long before;
    private  JFrame frame;
    private int score = 0;
    private Ball ball;
    public GameWindow() {
        frame = new JFrame();
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null); // Create frame on screen
        frame.setResizable(false);
        frame.setTitle("Bouncing Balls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setState(JFrame.NORMAL);
        //setUndecorated(true); Supprikmer le bar d'application

        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setFocusable(true);
        panel.setDoubleBuffered(true);
        frame.add(panel);//Ajouter le panel dans le JFrame

        ball = new Ball(20);
    }

    public void start() {
        frame.setVisible(true);
        before = System.currentTimeMillis();
        while (playing){
            bufferedImage = new BufferedImage(800,600,
                    BufferedImage.TYPE_INT_RGB); //image sur laquelle on va dessiner nos entite dessus
            buffer = bufferedImage.createGraphics(); // il fait le dessin dans l'image en mémoire il fait l'engin pour ecrire des chosee
            //graphique au bufferImage
            RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
            buffer.setRenderingHints(rh);

            update();
            drawOnBuffer();
            drawBufferOnScreen();

            long sleep = SLEEP - (System.currentTimeMillis()-before);
            if (sleep<0){
                sleep = 4;
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            before = System.currentTimeMillis();

        }
    }



    public void update() { // mettre a jour les variable pour que qund il affiche sa a l'air de bouger
      ball.update();
      if (ball.HasTouchBound()){
          score += 10;
      }
    }

    public void drawOnBuffer() {  // il affiche les affaires
       ball.draw(buffer);

        buffer.setPaint(Color.WHITE);
        buffer.drawString("Score : " + score,10,20);
    }

    public void drawBufferOnScreen() {
        Graphics2D graphics = (Graphics2D) panel.getGraphics();
        graphics.drawImage(bufferedImage,0,0,panel);
        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }




}
