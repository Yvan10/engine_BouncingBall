package engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameWindow extends JFrame {

    private static final int SLEEP = 25;
    private Random rnd = new Random();
    private boolean playing = true;
    private JPanel panel;
    private int radius = 25;
    private int x = 200;
    private int y = 200;
    private int dx = 1;
    private int dy = 1;
    private BufferedImage bufferedImage; // image sur laquelle on va dessiner nos entite dessus
    private Graphics2D buffer;
    private long before;
    private int score = 0;

    public GameWindow() {
        setSize(800,600);
        setLocationRelativeTo(null); // Create frame on screen
        setResizable(false);
        setTitle("Bouncing Balls");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setState(JFrame.NORMAL);
        //setUndecorated(true); Supprikmer le bar d'application

        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setFocusable(true);
        panel.setDoubleBuffered(true);
        add(panel);//Ajouter le panel dans le JFrame
    }

    public void start() {
        setVisible(true);
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



    public void update() {
    }

    public void drawOnBuffer() {
        buffer.setPaint(Color.RED);
        buffer.fillOval(x,y,radius * 2,radius * 2);

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
