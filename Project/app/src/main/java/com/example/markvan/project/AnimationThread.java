package com.example.markvan.project;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by markvan on 4/25/17.
 */

public class AnimationThread {
    public static final float DEFAULT_FPS = 30;

    private View v;

    private Sprite sprite;

    private Thread thread;

    private float framesPerSecond;

    private Handler handler;

    private volatile boolean isRunning;





    public AnimationThread(View aView, float fps) {
        v = aView;

        framesPerSecond = fps;

        isRunning = false;

        handler = new Handler(Looper.getMainLooper());
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(new ThreadRunner());
            thread.start();
        }
    }

    public void stop() {
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException ie) {
                Log.e("Animation Thread", "Thread interrupted");
            }

            thread = null;

            isRunning = false;
        }
    }

    private class ThreadRunner implements Runnable {

        @Override
        public void run() {
            isRunning = true;
            while (isRunning) {
                    try {

                        Thread.sleep((long)(1000 / framesPerSecond));

                        handler.post(new Updater());
                    } catch (InterruptedException ie) {
                        Log.e("Thread Runnger", "Thread sleep interrupted");
                    }
            }
        }
    }

    private class Updater implements Runnable {
        @Override
        public void run() {
            v.invalidate();
        }
    }

}
