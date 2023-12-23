package com.example.parcial2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
public class Temperatura extends View implements View.OnTouchListener {
    private int temperatura = 0;
    public Temperatura(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(255,255,255,255);
        int ancho = getWidth();
        int alto = getHeight();
        int radio = ancho/2;
        Paint p1 = new Paint();
        p1.setARGB(255,0,0,0);
        canvas.drawCircle(ancho*0.50f,alto*0.50f,radio,p1);
        Paint p2 = new Paint();
        p2.setARGB(255,0,255,0);
        p2.setTextSize(250);
        canvas.drawText(String.valueOf(temperatura), ancho*0.50f,alto*0.50f,p2);
        if(temperatura == 1 && temperatura < 10)
        {
            p1.setARGB(255,255,0,0);
        }
        if(temperatura == 10 && temperatura <20)
        {
            p1.setARGB(255,255,255,0);
        }
        if(temperatura == 20)
        {
            p1.setARGB(255,255,0,0);
        }

    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        temperatura = temperatura + 1;
        return false;
    }

    public void subirt ()
    {
        temperatura++;
    }
}
