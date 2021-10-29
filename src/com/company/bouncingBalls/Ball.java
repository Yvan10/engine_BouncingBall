package com.company.bouncingBalls;

import engine.Buffer;

import java.awt.*;
import java.util.Random;

public class Ball {
    private final Random random;
    private int radius;
    private int x ;
    private int y ;;
    private int velocityX;
    private int velocityY;

    public Ball(int radius){
        random = new Random();
        this.radius = radius;
         x = getRandomNumber(0 + radius * 2,800 - radius * 2);
         y = getRandomNumber(0 + radius * 2,600 - radius * 2);
         velocityX = getRandomNumber(0,1) == 0 ? 5 : -5; // la vitesse
         velocityY =  getRandomNumber(0,1) == 0 ? 5 : -5; // la vitesse
    }


    public void update(){
        x+= velocityX;
        y+= velocityY;
        if (hasTouchVerticalBound()){ // radius pour le prendre a moitié au niveau des bordures il represente le diametre
            velocityY *= -1;
        }

        if ( hasTouchHorizontalBound()){
            velocityX *= -1;
        }
    }

    public void draw(Buffer buffer){
        buffer.drawCircle(x,y,radius,Color.RED);
    }

    public boolean hasTouchHorizontalBound(){
        return  x <= radius ||x >= 800 - radius;
    }

    public boolean hasTouchVerticalBound(){
        return  y <= radius ||y >= 600 - radius;
    }

    public boolean HasTouchBound() {
        return hasTouchHorizontalBound() || hasTouchVerticalBound();
    }

    public int getRadius() {
        return radius;
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }


    private int getRandomNumber(int min, int max){
        return random.nextInt((max - min) +1) + min;
    }
}
