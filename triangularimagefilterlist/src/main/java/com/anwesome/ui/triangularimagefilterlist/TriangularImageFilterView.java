package com.anwesome.ui.triangularimagefilterlist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
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
    private OnSelectionChangeListener listener;
    private int time = 0,w,h;
    private TriangularImage triangularImage;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private TriangularFilter triangularFilter;
    private AnimationHandler animationHandler;
    public TriangularImageFilterView(Context context, Bitmap bitmap) {
        super(context);
        this.bitmap = bitmap;
    }
    public void setOnSelectionChangeListener(OnSelectionChangeListener listener) {
        this.listener = listener;
    }
    public void setColor(int color) {
        this.color = color;
    }
    public void update(float factor) {
        if(triangularFilter!=null) {
            triangularFilter.update(factor);
            postInvalidate();
        }
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
            triangularFilter = new TriangularFilter();
            animationHandler = new AnimationHandler();
        }
        canvas.drawColor(Color.WHITE);
        triangularImage.draw(canvas);
        triangularFilter.draw(canvas);
        time++;
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            animationHandler.start();
        }
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
    private class AnimationHandler extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener{
        private float dir = 0;
        private boolean isAnimating = false;
        private ValueAnimator startAnim = ValueAnimator.ofFloat(0,1),endAnim = ValueAnimator.ofFloat(1,0);
        public AnimationHandler() {
            startAnim.setDuration(500);
            endAnim.setDuration(500);
            startAnim.addUpdateListener(this);
            endAnim.addUpdateListener(this);
            startAnim.addListener(this);
            endAnim.addListener(this);
        }
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            update((float)valueAnimator.getAnimatedValue());
        }
        public void onAnimationEnd(Animator animator) {
            if(isAnimating) {
                dir = dir == 0?1:0;
                isAnimating = false;
                if(listener != null) {
                    if (dir == 1) {
                        listener.onSelect();
                    }
                    else {
                        listener.onUnSelect();
                    }
                }
            }
        }
        public void start() {
            if(!isAnimating) {
                if (dir == 0) {
                    startAnim.start();
                } else if (dir == 1) {
                    endAnim.start();
                }
                isAnimating = true;
            }
        }

    }
}
