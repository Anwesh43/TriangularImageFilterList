package com.anwesome.ui.triangularimagefilterlist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 17/05/17.
 */
public class TriangularImageFilterView extends View {
    private int color = Color.WHITE;
    private Bitmap bitmap;
    private int time = 0,w,h;
    public TriangularImageFilterView(Context context, Bitmap bitmap) {
        super(context);
    }
    public void setColor(int color) {
        this.color = color;
    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            w = canvas.getWidth();
            h = canvas.getHeight();
            bitmap = Bitmap.createScaledBitmap(bitmap,w,h,true);
        }
        time++;
    }
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
    private class TriangularImage {
        
    }
}
