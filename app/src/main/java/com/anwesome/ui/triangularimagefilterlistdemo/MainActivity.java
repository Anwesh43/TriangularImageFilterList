package com.anwesome.ui.triangularimagefilterlistdemo;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anwesome.ui.triangularimagefilterlist.OnSelectionChangeListener;
import com.anwesome.ui.triangularimagefilterlist.TriangularImageFilterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.stp);
        TriangularImageFilterView triangularImageFilterView = new TriangularImageFilterView(this,bitmap);
        triangularImageFilterView.setOnSelectionChangeListener(new OnSelectionChangeListener() {
            @Override
            public void onSelect() {
                Toast.makeText(MainActivity.this, "Selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onUnSelect() {
                Toast.makeText(MainActivity.this, "UnSelected", Toast.LENGTH_SHORT).show();
            }
        });
        addContentView(triangularImageFilterView,new ViewGroup.LayoutParams(600,600));
    }
}
