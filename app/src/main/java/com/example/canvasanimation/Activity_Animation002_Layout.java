package com.example.canvasanimation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Activity_Animation002_Layout extends SurfaceView implements Runnable {


    Canvas canvas;
    SurfaceHolder surfaceHolder;
    Bitmap backgroundCheckered;

    Paint red_paintbrush_fill, blue_paintbrush_fill, green_paintbrush_fill, black_paintbrush_fill;
    Paint red_paintbrush_stroke, blue_paintbrush_stroke, green_paintbrush_stroke, black_paintbrush_stroke, white_paintbrush_stroke;
    Path square;
    Path axes;

    // these are values needed for the animating one note

    int screen_center = (this.getResources().getDisplayMetrics().widthPixels)/2;

    int pixelToSecondRatio = 100; //100 pixels means one second
    int total_duration = 10; //seconds

    int pitch = 200;
    int duration_start = 4; //seconds
    int duration_end = 7; //seconds
    String instrument = "Guitar";

    int pitch2, duration_start2, duration_end2;
    String instrument2;

    int note_XTOP;
    int note_yTOP;
    int note_XBOTTOM;
    int note_yBOTTOM;

    int note_X2TOP;
    int note_y2TOP;
    int note_X2BOTTOM;
    int note_y2BOTTOM;

    int circle_x, circle_y;
    int rect1x, rect2x;




    Thread thread = null;
    boolean CanDraw = false;


    public Activity_Animation002_Layout(Context context) {
        super(context);
        surfaceHolder = getHolder();
        backgroundCheckered = BitmapFactory.decodeResource(getResources(), R.drawable.checker_bg);

        //HERE THE NOTE RECTANGLES WILL BE INITIALIZED, this part uses the pitch and stuff
        note_XTOP = screen_center + pixelToSecondRatio * duration_start;
        note_XBOTTOM = screen_center + pixelToSecondRatio * duration_end;

        note_yTOP = pitch + 50;
        note_yBOTTOM = pitch - 50;

    }



    @Override
    public void run() {
        prepPaintbrushes();

        while(CanDraw) {


            if (!surfaceHolder.getSurface().isValid()){
                continue;
            }

            canvas = surfaceHolder.lockCanvas();

            canvas.drawBitmap(backgroundCheckered, 0, 0, null);
            canvas.drawRect(0, 0, this.getResources().getDisplayMetrics().widthPixels, this.getResources().getDisplayMetrics().heightPixels, black_paintbrush_fill);

            canvas.drawRect(note_XTOP, note_yTOP, note_XBOTTOM , note_yBOTTOM , green_paintbrush_fill);

            //drawSquare(130, 650, 130, 650);
               // motionCircle(10);
                //canvas.drawCircle(circle_x, circle_y, 70 , red_paintbrush_fill);
            drawAxes(10, 10);
            try {
                animate_notes();
            } catch (InterruptedException e) { //need try catch for the the cool thread.sleep
                e.printStackTrace();
            }


            surfaceHolder.unlockCanvasAndPost(canvas);


        }
        //Log.d("Daiwik", "Out of while loop");



    }
    public void pause(){
        CanDraw = false;
        while(true) {
            try {
                thread.join();
                break; //will exit the loop if join is true
                // there are many reasons that thread my not close neatly
            } catch (InterruptedException e) {
         //       Log.d("Daiwik", "PrintStackTrace");
                e.printStackTrace();
            }
        }
        thread = null;


    }

    public void resume(){
        CanDraw = true;
        thread = new Thread(this);
        thread.start();
    }

    private void prepPaintbrushes(){
       // Log.d("Daiwik","Paint Prep");
        red_paintbrush_fill = new Paint();
        red_paintbrush_fill.setColor(Color.RED);
        red_paintbrush_fill.setStyle(Paint.Style.FILL);

        blue_paintbrush_fill = new Paint();
        blue_paintbrush_fill.setColor(Color.BLUE);
        blue_paintbrush_fill.setStyle(Paint.Style.FILL);

        green_paintbrush_fill = new Paint();
        green_paintbrush_fill.setColor(Color.GREEN);
        green_paintbrush_fill.setStyle(Paint.Style.FILL);

        black_paintbrush_fill = new Paint();
        black_paintbrush_fill.setColor(Color.BLACK);
        black_paintbrush_fill.setStyle(Paint.Style.FILL);



        red_paintbrush_stroke = new Paint();
        red_paintbrush_stroke.setColor(Color.RED);
        red_paintbrush_stroke.setStyle(Paint.Style.STROKE);
        red_paintbrush_stroke.setStrokeWidth(10);

        blue_paintbrush_stroke = new Paint();
        blue_paintbrush_stroke.setColor(Color.BLUE);
        blue_paintbrush_stroke.setStyle(Paint.Style.STROKE);
        blue_paintbrush_stroke.setStrokeWidth(10);

        green_paintbrush_stroke = new Paint();
        green_paintbrush_stroke.setColor(Color.GREEN);
        green_paintbrush_stroke.setStyle(Paint.Style.STROKE);
        green_paintbrush_stroke.setStrokeWidth(10);

        black_paintbrush_stroke = new Paint();
       black_paintbrush_stroke.setColor(Color.BLACK);
       black_paintbrush_stroke.setStyle(Paint.Style.STROKE);
       black_paintbrush_stroke.setStrokeWidth(5);

        white_paintbrush_stroke = new Paint();
        white_paintbrush_stroke.setColor(Color.WHITE);
        white_paintbrush_stroke.setStyle(Paint.Style.STROKE);
        white_paintbrush_stroke.setStrokeWidth(5);

    }

    private void animate_notes() throws InterruptedException {

        note_XTOP = note_XTOP - 5; //every 50 ms go 5 pixels, so every second it will translate 100 pixels
        note_XBOTTOM = note_XBOTTOM - 5;

        thread.sleep(50);
    }

    private void drawAxes(int min_pitch, int max_pitch){
        axes = new Path();
        axes.moveTo(130, 130);
        axes.lineTo(130, 1560);
        axes.moveTo(130, 1560);
        axes.lineTo(1560, 1560);
        this.canvas.drawPath(axes, white_paintbrush_stroke);

    }

    private void drawSquare(int x1, int x2, int y1, int y2){
       // Log.d("Daiwik", "In Draw Square");

        canvas.drawCircle(x1, y1, 70 , green_paintbrush_stroke);

        square = new Path();
        square.moveTo(x1, y1);
        square.lineTo(x2, y1);
        square.moveTo(x2, y1);
        square.lineTo(x2, y2);
        square.moveTo(x2, y2);
        square.lineTo(x1, y2);
        square.moveTo(x1, y2);
        square.lineTo(x1, y1);

        this.canvas.drawPath(square, red_paintbrush_stroke);
       // Log.d("Daiwik", "Out Draw Square");
    }

    private void motionCircle(int speed){
        if(circle_y == 130 && circle_x <650){
            circle_x = circle_x + speed;
        }
        if(circle_y <650 && circle_x == 650){
            circle_y = circle_y + speed;
        }
        if(circle_y == 650 && circle_x > 130){
            circle_x = circle_x - speed;
        }
        if(circle_y > 130 && circle_x == 130){
            circle_y = circle_y - speed;
        }

    }
    // Some notes
    //length will be based on time it is played
    //its position will be based on at what time the song starts
    //


}
