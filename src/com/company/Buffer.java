package com.company;

import java.awt.*;

public class Buffer {
    private final Graphics2D graphics;

    public Buffer(Graphics2D graphics) {
        this.graphics = graphics;
    }
    public void drawRectangle(int x, int y, int widht, int height, Paint paint){
        graphics.setPaint(paint);
        graphics.fillRect(x,y,widht,height);
    }
    public void drawCircle(int x, int y, int radius, Paint paint){
        graphics.setPaint(paint);
        graphics.fillOval(x,y,radius*2,radius*2);
    }
    public void drawText(String text, int x, int y, Paint paint) {
        graphics.setPaint(paint);
        graphics.drawString(text,x,y);
    }
}
