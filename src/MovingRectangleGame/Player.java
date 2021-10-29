package MovingRectangleGame;

import engine.Buffer;
import engine.control.MouvementController;
import engine.entities.ControllableEntity;

import java.awt.*;

public  class Player extends ControllableEntity {

    public Player(MouvementController controller){
        super(controller);
        teleport(100,100);
        setDimension(30,60);
        setSpeed(4);
    }

    public void update() {
        moveAccordingToController();
    }

    public void draw(Buffer buffer){
        buffer.drawRectangle(x,y,width,height, Color.RED);
    }
}
