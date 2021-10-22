package engine;

import com.company.Ball;
import com.company.Buffer;
import com.company.RenderingEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class Game {

    private static final int SLEEP = 25;

    private boolean playing = true;

    private long syncTime;
    private RenderingEngine renderingEngine;
    public  abstract void initialize();
    public  abstract void update();
    public abstract void draw(Buffer buffer);
    public  abstract void conclude();

    //abstract te force a avoir les enfant    et abstract final x t'empeche d'avoir des enfants

    public Game() {
        renderingEngine = new RenderingEngine();
    }

    public final void start(){ // on empeche de redefinir la methode
        initialize();;
        run();
        conclude();
    }

    public final void stop(){
        playing = false;
    }

    public void run() {
       renderingEngine.start();
        updateSyncTime();
        while (playing){

            update();
            draw(renderingEngine.getRenderingBuffer());
            //drawOnBuffer();
//            drawBufferOnScreen();
            renderingEngine.renderBufferOnScreen();
            sleep();
        }
        renderingEngine.stop();
    }



//    private void drawBufferOnScreen(){
//        renderingEngine.drawBufferOnScreen();
//    }

//    public void drawOnBuffer(Graphics2D buffer) {  // il affiche les affaires
//
//    }




    private void sleep(){
        try {
            Thread.sleep(getSleep());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateSyncTime();
    }

    private void updateSyncTime(){
        syncTime = System.currentTimeMillis();
    }

    private long getSleep(){
        long sleep = SLEEP - (System.currentTimeMillis()-syncTime);
        if (sleep<0){
            sleep = 4;
        }
        return sleep;
    }






}
