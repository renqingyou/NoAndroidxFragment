package com.example.renqingyou.noandroidxfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"我是Actvity上的text",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
