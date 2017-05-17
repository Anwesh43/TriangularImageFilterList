package com.anwesome.ui.triangularimagefilterlist;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ScrollView;

/**
 * Created by anweshmishra on 17/05/17.
 */
public class TriangularImageFilterList  {
    private Activity activity;
    private boolean isShown = false;
    private ScrollView scrollView;
    public TriangularImageFilterList(Activity activity) {
        this.activity = activity;
        scrollView = new ScrollView(activity);
    }
    public void addImage(Bitmap bitmap,OnSelectionChangeListener onSelectionChangeListener) {
        if(!isShown) {

        }
    }
    public void show() {
        if(!isShown) {
            activity.setContentView(scrollView);
            isShown = true;
        }
    }
}
