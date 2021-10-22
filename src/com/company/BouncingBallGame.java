package com.company;

import engine.Game;

import java.awt.*;

public class BouncingBallGame extends Game {
    private Ball ball;
    private int score = 0;

//    public BouncingBallGame(){
//        ball = new Ball(20);
//    }
    @Override
    public void initialize() {
        ball = new Ball(20);
    }

    @Override
    public void update() { // mettre a jour les variable pour que qaund il affiche sa a l'air de bouger
        ball.update();
        if (ball.HasTouchBound()){
            score += 10;
        }
    }

    @Override
    public void draw(Buffer buffer){
        ball.draw(buffer);
        buffer.drawText("Score" + score, 10,20,Color.WHITE);
    }

    @Override
    public void conclude(){}
}
