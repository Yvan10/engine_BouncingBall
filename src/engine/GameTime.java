package engine;


import java.util.concurrent.TimeUnit;

public class GameTime {
    private static final int FPS_TARGET = 60;
    private long syncTime;
    private static GameTime instance;
    private static int currentFps;
    private static long fpsTimeDelta;
    private static long gameStartTime;
    private static int fpsCount;



   

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static int getCurrentFps(){
        return (currentFps > 0) ? currentFps : fpsCount;
    }

    public static long getElapsedTime(){
        return System.currentTimeMillis() - gameStartTime;
    }
    
    public static String getElapsedFormattedTime() {
        long time = System.currentTimeMillis() - gameStartTime;
        long hours = TimeUnit.MILLISECONDS.toHours(time);
        time -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time);
        time -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time);
        time -= TimeUnit.SECONDS.toMillis(seconds); // Pour millisecondes restantes
        return String.format("%02d:%02d:%02d",hours,minutes,seconds);
    }
    
    protected static GameTime  getInstance() { // Limiter la portée au package // pour kil marche il faut kil soit toute dans le meme package pour les classes ki l'utilse
        if (instance == null){
            instance = new GameTime();
        }
        return instance;
    }
    
    protected void synchronize() { // pour kil marche il faut kil soit toute dans le meme package pour les classes ki l'utilse
        update();
        try {
            Thread.sleep(getSleepTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateSynchronisationTime();
    }
    

    private void updateSynchronisationTime(){
        syncTime = System.currentTimeMillis();
    }

    private long getSleepTime(){
        long targetTime =  1000L / FPS_TARGET;
        long sleep = targetTime - (System.currentTimeMillis() - syncTime);
        if (sleep<0){
            sleep = 4;
        }
        return sleep;
    }
    
    private void update() {
        fpsCount++;
        long currentSecond = TimeUnit.MILLISECONDS.toSeconds(getElapsedTime());
        if (fpsTimeDelta != currentSecond) {
            currentFps = fpsCount;
            fpsCount = 0;
        }
        fpsTimeDelta = currentSecond;
    }

    private GameTime(){
        updateSynchronisationTime(); //pour que lorsque lance le jeu le temp commence d'ou la methode est privé et il est au constructeur pour ne pas etre appeler
        gameStartTime = System.currentTimeMillis();
        fpsTimeDelta = 0;
        currentFps = 0;
    }
}
