package com.mygdx.first;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    private int x;
    private int y;
    private int size;
    private int xSpeed;
    private int ySpeed;
    private Color color = Color.WHITE;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;
        if (x < size || x > Gdx.graphics.getWidth() - size) {
            xSpeed = -xSpeed;
        }
        if (y < size || y > Gdx.graphics.getHeight() - size) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, size);
    }

    public void checkPaddleCollision(Paddle paddle) {
        if(collidesWithPaddle(paddle)){
            ySpeed = -ySpeed;
        }
    }

    public void checkBlockCollision(Block block) {
        if(collidesWithBlock(block)){
            ySpeed = -ySpeed;
            block.setDestroyed(true);
            }
        }

    private boolean collidesWithPaddle(Paddle paddle) {
        if (x + size < paddle.getX() || x - size > paddle.getX() + paddle.getWidth() || y + size < paddle.getY() || y - size > paddle.getY() + paddle.getHeight()) {
            return false;
        }
        return true;
    }

    private boolean collidesWithBlock(Block block) {
        if (x + size < block.getX() || x - size > block.getX() + block.getWidth() || y + size < block.getY() || y - size > block.getY() + block.getHeight()) {
            return false;
        }
        return true;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public Color getColor() {
        return color;
    }
}
