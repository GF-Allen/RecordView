package com.chinajesit.recordview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.chinajesit.recordview.widget.RecordManager;
import com.chinajesit.recordview.widget.RecordView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private RecordView recordView;
    private RecordManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recordView = (RecordView) findViewById(R.id.recordView);
        manager = new RecordManager(new File(getExternalCacheDir().getPath()+"/"+System.currentTimeMillis()+".amr"));
        manager.setOnVolume(new RecordManager.OnVolume() {
            @Override
            public void onVolume(int db) {
                recordView.setVolume(db);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        recordView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        recordView.onPause();
    }

    public void start(View view) {
        recordView.startAnim();
        manager.startRecord();
    }

    public void stop(View view) {
        recordView.stopAnim();
        manager.stopRecord();
    }
}
