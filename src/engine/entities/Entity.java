package engine.entities;

import engine.Buffer;

public abstract class Entity {
    protected int x;
    protected int y;

    public  abstract void draw(Buffer buffer);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    protected int width;
    protected int height;

    public void teleport(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setDimension(int width, int height){
        this.width = width;
        this.height = height;
    }
}
