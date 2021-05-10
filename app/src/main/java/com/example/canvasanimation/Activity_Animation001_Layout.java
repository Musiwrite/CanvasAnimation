package com.example.canvasanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.Rectangle;


public class Activity_Animation001_Layout extends View {

    Paint red_paintbrush_fill, blue_paintbrush_fill, green_paintbrush_fill;
    Paint red_paintbrush_stroke, blue_paintbrush_stroke, green_paintbrush_stroke;
    Path triangle;

    @NonNull
    @Override
    public int[] getAttributeResolutionStack(int attribute) {
        return super.getAttributeResolutionStack(attribute);
    }

    public Activity_Animation001_Layout(Context context) {
        super(context);
        //set background
    }

    public Activity_Animation001_Layout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Activity_Animation001_Layout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Activity_Animation001_Layout(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //setting the paintbrushes
        red_paintbrush_fill = new Paint();
        red_paintbrush_fill.setColor(Color.RED);
        red_paintbrush_fill.setStyle(Paint.Style.FILL);

        blue_paintbrush_fill = new Paint();
        blue_paintbrush_fill.setColor(Color.BLUE);
        blue_paintbrush_fill.setStyle(Paint.Style.FILL);

        green_paintbrush_fill = new Paint();
        green_paintbrush_fill.setColor(Color.GREEN);
        green_paintbrush_fill.setStyle(Paint.Style.FILL);


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


        Rect rectangle001 = new Rect();
        rectangle001.set(210, 215, 250, 175);
        canvas.drawRect(rectangle001, red_paintbrush_stroke);
        //draw the rect with a paint brush


        Rect rectangle002 = new Rect();
        rectangle001.set(420, 215, 460, 175);
        canvas.drawRect(rectangle001, blue_paintbrush_fill);

        canvas.drawCircle(400, 400, 70 , blue_paintbrush_stroke);
        canvas.drawCircle(400, 400, 20 , red_paintbrush_fill);
        canvas.drawCircle(400, 400, 10 , green_paintbrush_fill);

        triangle = new Path();
        triangle.moveTo(400, 400);
        triangle.lineTo(600, 600);
        triangle.moveTo(600, 600);
        triangle.lineTo(200, 600);
        triangle.moveTo(200, 600);
        triangle.lineTo(400, 400);


        canvas.drawPath(triangle, red_paintbrush_stroke);
        //need to come after the draw path


        canvas.drawCircle(600, 600, 70 , blue_paintbrush_stroke);
        canvas.drawCircle(600, 600, 20 , red_paintbrush_fill);
        canvas.drawCircle(600, 600, 10 , green_paintbrush_fill);

        canvas.drawCircle(200, 600, 70 , blue_paintbrush_stroke);
        canvas.drawCircle(200, 600, 20 , red_paintbrush_fill);
        canvas.drawCircle(200, 600, 10 , green_paintbrush_fill);











    }
}
