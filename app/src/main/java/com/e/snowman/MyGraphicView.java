package com.e.snowman;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import static android.graphics.drawable.GradientDrawable.RECTANGLE;

import static com.e.snowman.MainActivity.background;
import static com.e.snowman.MainActivity.blue;
import static com.e.snowman.MainActivity.clothes;
import static com.e.snowman.MainActivity.earmuff;
import static com.e.snowman.MainActivity.green;
import static com.e.snowman.MainActivity.hat;
import static com.e.snowman.MainActivity.red;
import static com.e.snowman.MainActivity.scarf;
import static com.e.snowman.MainActivity.street;
import static com.e.snowman.MainActivity.tree;
import static com.e.snowman.MainActivity.village;
import static com.e.snowman.MainActivity.curColor;
import static com.e.snowman.MainActivity.white;

class MyGraphicView extends View {


    final static  int LINE = 1;
    int startX=-1, startY=-1, stopX=-1, stopV=-1;

    static int curShape = LINE;


    public MyGraphicView(Context context){
        super(context);
    }


    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);




        //배경지정
        switch (background){
            case street:


                this.invalidate();
                Bitmap street = BitmapFactory.decodeResource(getResources(), R.drawable.street);
                paint.setFilterBitmap(true);
                Rect dest1 = new Rect(0, 0, getWidth(), getHeight());
                canvas.drawBitmap(street, null, dest1, paint);
                break;

            case tree:


                this.invalidate();
                Bitmap tree = BitmapFactory.decodeResource(getResources(), R.drawable.tree);
                paint.setFilterBitmap(true);
                Rect dest2 = new Rect(0, 0, getWidth(), getHeight());
                canvas.drawBitmap(tree, null, dest2, paint);
                break;



            case village:


                this.invalidate();
                Bitmap village = BitmapFactory.decodeResource(getResources(), R.drawable.village);
                paint.setFilterBitmap(true);
                Rect dest3 = new Rect(0, 0, getWidth(), getHeight());
                canvas.drawBitmap(village, null, dest3, paint);
                break;

        }




        switch (curColor){
            case red:
                this.invalidate();
                paint.setColor(Color.RED);
                canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/5*2, canvas.getWidth()/6, paint);
                canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/7*5 - 50 , canvas.getWidth()/3, paint);
                break;
            case green:
                this.invalidate();
                paint.setColor(Color.GREEN);
                canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/5*2, canvas.getWidth()/6, paint);
                canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/7*5 - 50, canvas.getWidth()/3, paint);
                break;
            case blue:
                this.invalidate();
                paint.setColor(Color.BLUE);
                canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/5*2, canvas.getWidth()/6, paint);
                canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/7*5 - 50, canvas.getWidth()/3, paint);
                break;

            case white:
                this.invalidate();
                paint.setColor(Color.WHITE);
                canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/5*2, canvas.getWidth()/6, paint);
                canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/7*5 - 50, canvas.getWidth()/3, paint);
                break;
        }

        switch (clothes){
            case hat:
                this.invalidate();
                Bitmap hat = BitmapFactory.decodeResource(getResources(),R.drawable.hat);
                Bitmap re_hat=Bitmap.createScaledBitmap(hat, 400,350,false);
                paint.setFilterBitmap(true);
                 Rect dest4 = new Rect(canvas.getWidth()/2- canvas.getWidth()/6 ,canvas.getHeight()/5*2 - canvas.getWidth()/3 , canvas.getWidth()/2- canvas.getWidth()/6 + re_hat.getWidth(), canvas.getHeight()/5*2 - canvas.getWidth()/3-100+ re_hat.getHeight());
                 canvas.drawBitmap(re_hat, null, dest4, paint);
                break;

            case scarf:
                this.invalidate();
                Bitmap scarf = BitmapFactory.decodeResource(getResources(),R.drawable.scarf);
                Bitmap re_scarf=Bitmap.createScaledBitmap(scarf, 450 ,450,false);
                paint.setFilterBitmap(true);
                Rect dest5 = new Rect(canvas.getWidth()/2 - canvas.getWidth()/6, canvas.getHeight()/5*2 + canvas.getWidth()/6 -100, canvas.getWidth()/2 - canvas.getWidth()/6 + re_scarf.getWidth(),  canvas.getHeight()/5*2+ canvas.getWidth()/6+  re_scarf.getHeight());
                canvas.drawBitmap(re_scarf, null, dest5, paint);
                break;

            case earmuff:
                this.invalidate();
                Bitmap earmuff = BitmapFactory.decodeResource(getResources(),R.drawable.earmuff);
                Bitmap re_earmuff=Bitmap.createScaledBitmap(earmuff, 400,400,false);
                paint.setFilterBitmap(true);
                Rect dest6 = new Rect(canvas.getWidth()/2- canvas.getWidth()/6 -100 ,canvas.getHeight()/5*2 -230, canvas.getWidth()/2+ canvas.getWidth()/6 +100, canvas.getHeight()/5*2 + 200);
                canvas.drawBitmap(re_earmuff, null, dest6, paint);
                break;

        }


        //눈
        paint.setColor(Color.BLACK);
        canvas.drawCircle(getWidth()/2 - 50, getHeight()/2 - 180, 20, paint);
        canvas.drawCircle(getWidth()/2 + 50, getHeight()/2- 180, 20, paint);

        //입
        RectF rect = new RectF();
        rect.set(getWidth()/2 - 50, getHeight()/2-130, getWidth()/2 + 50, getHeight()/2 -100);
        canvas.drawArc(rect,0, 180, false,paint);

        //단추
        paint.setColor(Color.BLACK);
        canvas.drawCircle(getWidth()/2, canvas.getHeight()/7*5  + 10, 20, paint);
        canvas.drawCircle(getWidth()/2 , canvas.getHeight()/7*5 - 50, 20, paint);
        canvas.drawCircle(getWidth()/2 , canvas.getHeight()/7*5 - 110, 20, paint);




            }

        }

