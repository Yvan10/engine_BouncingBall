package engine.entities;

import MovingRectangleGame.InputHandler;
import engine.control.MouvementController;

public abstract  class ControllableEntity extends MovableEntity {

    private MouvementController controller;

    public ControllableEntity(MouvementController controller) {
        this.controller = controller;
    }

    public void moveAccordingToController(){
        if (!controller.isMoving()){
            return;
        }
        if (controller.isUpPressed()) {
            moveUp();
        } else if (controller.isDownPressed()) {
            moveDown();
        }else if (controller.isLeftPressed()) {
          moveLeft();
        }else if (controller.isRightPressed()) {
            moveRigt();
        }
    }

}
