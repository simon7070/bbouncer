package com.example.bouncerexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;



public class AnimationView extends View {
    public AnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // Set the Handler Object
        h = new Handler();

        // Paint object
        paint = new Paint();
        paint.setColor(Color.BLUE); // Set Paint Color

        // Create Ball Objects
        myBall = new Ball(100,100,Color.BLUE, 50);
        greenBall = new Ball(200, 200, Color.GREEN, 55);
        redBall = new Ball(50, 400, Color.RED, 75);
        orangeBall = new Ball(120, 230, Color.rgb(255,69,0), 80);
        yellowBall = new Ball(30, 100, Color.YELLOW, 45);

        // Set Speed of myBall
        myBall.setDX(10);
        myBall.setDY(10);


        // Set Speeds of greenBall and redBall
        greenBall.setDX(-20);
        greenBall.setDY(-15);
        redBall.setDX(-10);
        redBall.setDY(-5);
        orangeBall.setDX(-15);
        orangeBall.setDY(-5);
        yellowBall.setDX(10);
        yellowBall.setDY(-2);

    } // End Constructor AnimationView

    protected void onDraw(Canvas c) {
        // Calculate the Model
        myBall.bounce(c); // myBall Move and Bounce off Walls - model
        greenBall.bounce(c);
        redBall.bounce(c);
        orangeBall.bounce(c);
        yellowBall.bounce(c);

        // Draw the images taking data from the Ball models
        c.drawCircle(myBall.getX(), myBall.getY(), myBall.getRadius(),myBall.getPaint());
        c.drawCircle(greenBall.getX(),greenBall.getY(), greenBall.getRadius(), greenBall.getPaint());
        c.drawCircle(redBall.getX(), redBall.getY(), redBall.getRadius(), redBall.getPaint());
        c.drawCircle(orangeBall.getX(), orangeBall.getY(), orangeBall.getRadius(), orangeBall.getPaint());
        c.drawCircle(yellowBall.getX(), yellowBall.getY(), yellowBall.getRadius(), yellowBall.getPaint());


        // Call the Runnable to re-calculate the model and
        // Draw the Animation

        h.postDelayed(r, FRAME_RATE);
    }

    private Runnable r = new Runnable() {
        public void run() {
            invalidate(); // Calls the onDraw in View Objects
        } // end runnable r
    }; // End class Animation View


    // Rate for Animation
    private final int FRAME_RATE = 15;

    // Paint Object - for Setting Graphic Colors
    private Paint paint;

    // Handler for animation timing
    private Handler h;

    // objects in Animation
    Ball myBall;
    Ball greenBall;
    Ball redBall;
    Ball orangeBall;
    Ball yellowBall;



}
