package com.example.markvan.project;

import android.graphics.Canvas;

/**
 * Created by markvan on 4/25/17.
 */

public class BallSprite extends Sprite {

    public final static float DEFAULT_SIZE = 100.f;

    public BallSprite(float xLoc, float yLoc, float xVel, float yVel) {
        super(xLoc, yLoc, xVel, yVel);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawOval(super.getRect(), super.getPaint());
    }
}
