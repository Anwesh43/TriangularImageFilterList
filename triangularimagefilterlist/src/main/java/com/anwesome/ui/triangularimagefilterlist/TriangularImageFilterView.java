package com.anwesome.ui.triangularimagefilterlist;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 17/05/17.
 */
public class TriangularImageFilterView extends View {
    public TriangularImageFilterView(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {

    }
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
