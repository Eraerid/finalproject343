package com.example.markvan.project;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by markvan on 4/25/17.
 */

public class AnimationView extends View {

    private AnimationThread at;

    private List<Sprite> sList;

    private BallSprite sprite1 = new BallSprite(300, 300, 25, 25);


    public AnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        initAnimationView();


    }

    private void initAnimationView() {

        this.sList = new ArrayList<Sprite>();


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
       /* for (int i = 0; i < this.sList.size(); i++) {
            Sprite sprite = this.sList.get(i);
            sprite.updateLocation(this.getWidth(), this.getHeight());
        }*/

        Sprite sprite = this.sprite1;

    }

    public void drawAllSprites(Canvas canvas) {
      /*  for (int i = 0; i < this.sList.size(); i++) {
            Sprite sprite = this.sList.get(i);
            sprite.draw(canvas);
        }*/
        Sprite sprite = this.sprite1;
        sprite.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        float xTouch = me.getX();
        float yTouch = me.getY();

        return super.onTouchEvent(me);
    }
}

