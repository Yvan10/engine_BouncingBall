package engine;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private JPanel panel;
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
    }
}