package com.anwesome.ui.triangularimagefilterlist;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * Created by anweshmishra on 17/05/17.
 */
public class TriangularImageFilterList  {
    private Activity activity;
    private boolean isShown = false;
    private ScrollView scrollView;
    private ListLayout listLayout;
    public TriangularImageFilterList(Activity activity) {
        this.activity = activity;
        scrollView = new ScrollView(activity);
        listLayout = new ListLayout(activity);
        scrollView.addView(listLayout,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
    public void addImage(Bitmap bitmap,OnSelectionChangeListener onSelectionChangeListener) {
        if(!isShown) {
            listLayout.addImage(bitmap,onSelectionChangeListener);
        }
    }
    public void show() {
        if(!isShown) {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            activity.setContentView(scrollView);
            isShown = true;
        }
    }
}
