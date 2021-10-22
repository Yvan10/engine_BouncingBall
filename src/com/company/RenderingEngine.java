package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class RenderingEngine {
    private JPanel panel;
    private BufferedImage bufferedImage; // image sur laquelle on va dessiner nos entite dessus
    private  JFrame frame;

    public RenderingEngine(){
        initialiseFrame();
        initialisePanel();
    }

    public void renderBufferOnScreen() {
        Graphics2D graphics = (Graphics2D) panel.getGraphics();
        graphics.drawImage(bufferedImage,0,0,panel);
        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }

    public void start(){
        frame.setVisible(true);
    }
    public void stop(){

        frame.setVisible(false); // ferme la fenetre ouvert plus haut
        frame.dispose();
    }


    public Buffer getRenderingBuffer(){  // Buffer impeu koe public int mais c une classe qui retourne
        bufferedImage = new BufferedImage(800,600,
                BufferedImage.TYPE_INT_RGB); //image sur laquelle on va dessiner nos entite dessus
        Graphics2D graphics = bufferedImage.createGraphics(); // il fait le dessin dans l'image en mémoire il fait l'engin pour ecrire des chosee
        //graphique au bufferImage

        graphics.setRenderingHints(getOptimalRenderingHints());
      return  new Buffer( graphics);
    }


    private RenderingHints getOptimalRenderingHints(){
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);

        return rh;
    }

    private void initialiseFrame(){
        frame = new JFrame();
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null); // Create frame on screen
        frame.setResizable(false);
        frame.setTitle("Bouncing Balls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setState(JFrame.NORMAL);
        //setUndecorated(true); Supprimer le bar d'application

    }
    private void initialisePanel(){
        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setFocusable(true);
        panel.setDoubleBuffered(true);
        frame.add(panel);//Ajouter le panel dans le JFrame

    }
}
