package com.example.markvan.project;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by markvan on 4/25/17.
 */

public class AnimationView extends View {

    private AnimationThread at;

    private List<Sprite> sList;

    private Vector<Sprite> pVector;

    private BallSprite sprite1 = new BallSprite(1300, 1300, 10, 10);

    private Projectile projectile1 = new Projectile(200, 200, 10, 10);

    public AnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initAnimationView();


    }

    private void initAnimationView() {

        this.sList = new ArrayList<Sprite>();
        this.pVector = new Vector<Sprite>();

        projectile1.setPaint(projectile1.getPaint());
        projectile1.setSize(Projectile.DEFAULT_SIZE, Projectile.DEFAULT_SIZE);
        this.pVector.add(projectile1);

        sprite1.setSize(BallSprite.DEFAULT_SIZE, BallSprite.DEFAULT_SIZE);
        this.sList.add(sprite1);

        this.at = new AnimationThread(this, AnimationThread.DEFAULT_FPS);
        this.at.start();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawAllSprites(canvas);
        updateAllSprites();
    }

    private void updateAllSprites() {
     /*  for (int i = 0; i < this.sList.size(); i++) {
            Sprite sprite = this.sList.get(i);
            sprite.updateLocation(this.getWidth(), this.getHeight());
        }*/
        for(int i = 0; i < pVector.size(); i++) {
            Sprite projectile = pVector.get(i);
            pVector.set(i, projectile);
        }
        Sprite sprite = this.sprite1;
    }

    public void drawAllSprites(Canvas canvas) {

        for(int i = 0; i < this.sList.size(); i++) {
            Sprite ball = this.sList.get(i);
            ball.draw(canvas);
        }
        for(int i = 0; i < this.pVector.size(); i++) {
            Sprite sprite = this.pVector.get(i);
            sprite.draw(canvas);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        float xTouch = me.getX();
        float yTouch = me.getY();
        float yVel = projectile1.getyVelocity();

        sprite1.setxVelocity(xTouch);
        sprite1.setLocation(me.getX(), 1300);
        sprite1.updateLocation(me.getX(), 0);

        for(int i = 0; i < pVector.size(); i++) {
            projectile1.setyVelocity(yVel *= -1);
            projectile1.setLocation(sprite1.getxVelocity(), 1300);
            projectile1.move();
        }


        return super.onTouchEvent(me);
    }
}

