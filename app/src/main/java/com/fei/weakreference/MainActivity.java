package com.fei.weakreference;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mShowToastBtn;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(MainActivity.this, "get message", Toast.LENGTH_SHORT).show();
        }
    };
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Remove any pending posts of callbacks and sent messages whose obj is token.
        //If token is null, all callbacks and messages will be removed.
        mHandler.removeCallbacksAndMessages(null);
    }
}
