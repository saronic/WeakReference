package com.fei.weakreference;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private Button mShowToastBtn;
    private Handler mHandler = new MyHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowToastBtn = (Button) findViewById(R.id.activity_main_show_toast_btn);
        mShowToastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHandler.sendEmptyMessage(0);
            }
        });
    }

    private static class MyHandler extends Handler {
        private WeakReference<Activity> mActivityReference;

        public MyHandler(Activity activity) {
            mActivityReference = new WeakReference<Activity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(mActivityReference.get(), "get message", Toast.LENGTH_SHORT).show();
        }
    }

}
