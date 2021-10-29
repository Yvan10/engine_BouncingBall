package engine;


import java.awt.event.KeyListener;

public abstract class Game {
    private GameTime gameTime;
    private boolean playing = true;
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

    public void addKeyListener(KeyListener listener){
        renderingEngine.addKeyListener(listener);
    }
    public void run() {
       renderingEngine.start();
        GameTime.getInstance();
        while (playing){

            update();
            draw(renderingEngine.getRenderingBuffer());
            //drawOnBuffer();
//            drawBufferOnScreen();
            renderingEngine.renderBufferOnScreen();
            GameTime.getInstance().synchronize();
        }
        renderingEngine.stop();
    }



//    private void drawBufferOnScreen(){
//        renderingEngine.drawBufferOnScreen();
//    }

//    public void drawOnBuffer(Graphics2D buffer) {  // il affiche les affaires
//
//    }



}
