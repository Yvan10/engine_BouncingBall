package engine.entities;

import engine.control.Direction;

public abstract  class MovableEntity extends Entity{

    private Direction direction;
    private int speed;


    public void moveUp(){
        move(Direction.UP);
    } public void moveDown(){
        move(Direction.DOWN);
    }

    public void moveLeft(){
        move(Direction.LEFT);
    }
        public void moveRigt() {
            move(Direction.RIGHT);
        }
    public void move(Direction direction){
        this.direction = direction;
        x+= direction.getVelocityX(speed);
        y+= direction.getVelocityY(speed);
    }

    public int getSlepp() {
        return speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

}
