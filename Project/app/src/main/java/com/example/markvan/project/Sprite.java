package com.example.markvan.project;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.ArrayList;

/**
 * Created by markvan on 4/25/17.
 */

public abstract class Sprite {

    private RectF rect = new RectF();

    private float xVel = 0.0f;

    private float yVel = 0.0f;

    private Paint paint = new Paint(Color.RED);

    private float locationY;

    private float locationX;


    public Sprite(float locationX, float locationY, float xVelocity, float yVelocity) {
        rect.offsetTo(locationX, locationY);
        this.locationX = locationX;
        this.locationY = locationY;
        xVel = xVelocity;
        yVel = yVelocity;
    }

    public void setLocation(float x, float y) {
        rect.offsetTo(x, y);
    }

    public void setVelocity(float x, float y) {
        xVel = x;
        yVel = y;
    }

    public void setSize(float width, float height) {
        rect.set(rect.left, rect.top, (rect.left + width), (rect.top + height));
    }

    public void move() {

    }

    public void updateLocation(float width, float height) {
        this.move();

        if (rect.left < 0 || rect.right > width) {
            xVel *= -1;
        }

        if (rect.top < 0 || rect.bottom > height) {
            yVel *= -1;
        }
    }


    public RectF getRect() {
        return rect;
    }

    public void setRect(RectF rect) {
        this.rect = rect;
    }

    public float getxVelocity() {
        return this.xVel;
    }

    public void setxVelocity(float xVelocity) {
        this.xVel = xVelocity;
    }

    public float getyVelocity() {
        return this.yVel;
    }

    public void setyVelocity(float yVelocity) {
        this.yVel = yVelocity;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public abstract void draw(Canvas canvas);
}
