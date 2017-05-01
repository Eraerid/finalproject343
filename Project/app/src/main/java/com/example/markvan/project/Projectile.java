package com.example.markvan.project;

import android.graphics.Canvas;

/**
 * Created by markvan on 5/1/17.
 */

public class Projectile extends Sprite {

    public final static float DEFAULT_SIZE = 15.0f;

    public Projectile(float xLoc, float yLoc, float xVel, float yVel) {
        super(xLoc, yLoc, xVel, yVel);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(super.getRect(), super.getPaint());
    }
}
