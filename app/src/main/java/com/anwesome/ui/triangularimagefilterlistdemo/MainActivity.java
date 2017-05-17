package com.anwesome.ui.triangularimagefilterlistdemo;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anwesome.ui.triangularimagefilterlist.OnSelectionChangeListener;
import com.anwesome.ui.triangularimagefilterlist.TriangularImageFilterList;
import com.anwesome.ui.triangularimagefilterlist.TriangularImageFilterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.stp);
        TriangularImageFilterList triangularImageFilterList = new TriangularImageFilterList(this);
        for(int i=0;i<10;i++) {
            final int index = i;
            triangularImageFilterList.addImage(bitmap, new OnSelectionChangeListener() {
                @Override
                public void onSelect() {
                    Toast.makeText(MainActivity.this, String.format("%d selected",index), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onUnSelect() {
                    Toast.makeText(MainActivity.this, String.format("%d unselected",index), Toast.LENGTH_SHORT).show();
                }
            });
        }
        triangularImageFilterList.show();
    }
}
