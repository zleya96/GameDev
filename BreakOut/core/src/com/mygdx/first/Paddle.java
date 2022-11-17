package com.mygdx.first;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color = Color.WHITE;

    public Paddle(int width, int height) {
        y = 10;
        this.width = width;
        this.height = height;
    }

    public void update() {
        x = Gdx.input.getX() - (width / 2);
//        y = Gdx.graphics.getHeight() - Gdx.input.getY();

        if (x < 0) {
            x = 0;
        }
        if (x > Gdx.graphics.getWidth() - (width)){
            x = Gdx.graphics.getWidth() - width;
        }

    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.rect(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}

