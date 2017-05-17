package com.anwesome.ui.triangularimagefilterlist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anweshmishra on 17/05/17.
 */
public class ListLayout extends ViewGroup{
    private int w,h,viewSize;
    public ListLayout(Context context) {
        super(context);
        initDimension(context);
    }
    private void initDimension(Context context) {
        DisplayManager displayManager = (DisplayManager)context.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        if(display != null) {
            Point size = new Point();
            display.getRealSize(size);
            w = size.x;
            h = size.y;
            viewSize = h/4;
        }
    }
    public void onMeasure(int wspec,int hspec) {
        int newH = h/10;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            measureChild(child,wspec,hspec);
            newH += child.getMeasuredHeight()+h/20;
        }
        setMeasuredDimension(w,Math.max(newH,h));
    }
    public void onLayout(boolean reloaded,int a,int b,int w,int h) {
        int y = h/10;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            child.layout(w/2-viewSize/2,y,w/2+viewSize/2,y+viewSize);
            y += viewSize + h/20;
        }
    }
    public void addImage(Bitmap bitmap,OnSelectionChangeListener onSelectionChangeListener) {
        TriangularImageFilterView triangularImageFilterView = new TriangularImageFilterView(getContext(),bitmap);
        triangularImageFilterView.setOnSelectionChangeListener(onSelectionChangeListener);
        addView(triangularImageFilterView,new LayoutParams(viewSize,viewSize));
        requestLayout();
    }
}
