package com.anwesome.ui.triangularimagefilterlist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 17/05/17.
 */
public class TriangularImageFilterView extends View {
    private int color = Color.WHITE;
    private Bitmap bitmap;
    private int time = 0,w,h;
    private TriangularImage triangularImage;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public TriangularImageFilterView(Context context, Bitmap bitmap) {
        super(context);
    }
    public void setColor(int color) {
        this.color = color;
    }
    private Path getTrianglePath(float radius) {
        Path path = new Path();
        int deg = -90;
        for(int i=0;i<3;i++) {
            float x = (float)(w/2+(radius)*Math.cos(deg*Math.PI/180)),y = (float)(h/2+(radius)*Math.sin(deg*Math.PI/180));
            if(i == 0) {
                path.moveTo(x,y);
            }
            else {
                path.lineTo(x,y);
            }
        }
        return path;
    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            w = canvas.getWidth();
            h = canvas.getHeight();
            bitmap = Bitmap.createScaledBitmap(bitmap,w,h,true);
            triangularImage = new TriangularImage();
        }
        canvas.drawColor(Color.WHITE);
        triangularImage.draw(canvas);
        time++;
    }
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
    private class TriangularImage {
        public void draw(Canvas canvas) {
            canvas.save();
            canvas.clipPath(getTrianglePath(w/2));
            canvas.drawBitmap(bitmap,0,0,paint);
            canvas.restore();
        }
    }
    private class TriangularFilter {
        private float radius = 0;
        public void draw(Canvas canvas) {
            paint.setColor(Color.argb(150,Color.red(color),Color.green(color),Color.blue(color)));
            canvas.drawPath(getTrianglePath(radius),paint);
        }
        public void update(float factor) {
            radius = (w/2)*factor;
        }
    }
}
