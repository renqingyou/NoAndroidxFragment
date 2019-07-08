package com.example.renqingyou.noandroidxfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


import com.sensorsdata.analytics.android.sdk.SensorsDataTrackEvent;


public class MainActivity extends AppCompatActivity  {

    /**
     * 提示对话框
     */
    @SensorsDataTrackEvent(eventName = "myevent", properties = "{\"provider\":\"神策数据\",\"number\":100,\"isLogin\":true}")
    public void popDialog1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("问题：");
        builder.setMessage("请问你满十八岁了吗?");
        builder.setIcon(R.mipmap.ic_launcher_round);
        //点击对话框以外的区域是否让对话框消失
        builder.setCancelable(true);
        //设置正面按钮
        builder.setPositiveButton("是的", (dialog, which) -> {
            Toast.makeText(MainActivity.this, "你点击了是的", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        //设置反面按钮
        builder.setNegativeButton("不是", (dialog, which) -> {
            Toast.makeText(MainActivity.this, "你点击了不是", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        //设置中立按钮
        builder.setNeutralButton("保密", (dialog, which) -> {
            Toast.makeText(MainActivity.this, "你选择了保密", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        builder.show().setOwnerActivity(this);
    }

    public void printV(View v) {
        Log.e("rqy","View--"+v);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ActionBar Title");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Dialog dialog = builder.create();
        View view1 = new View(this);
        findViewById(R.id.bt3).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MyTabHostActivity.class);
            startActivity(intent);
            printV(v);
            printV(view1);
            dialog.dismiss();
        });

        Toolbar toolbar = new Toolbar(this);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });

        toolbar.setOnMenuItemClickListener(menuItem -> false);

        ListView listView = new ListView(this);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            printV(view1);
        });

        findViewById(R.id.navigationView).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NavigationViewActivity.class);
            startActivity(intent);
        });

       findViewById(R.id.bt0).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MyFragmentActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.bt1).setOnClickListener(view -> popDialog1());
        findViewById(R.id.bt2).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MyTabLayout.class);
            startActivity(intent);
        });

        findViewById(R.id.bt3).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MyTabHostActivity.class);
            startActivity(intent);
        });


        NavigationView navigationView = new NavigationView(this);
        navigationView.setNavigationItemSelectedListener(menuItem -> false);

        SwitchCompat switchCompat = findViewById(R.id.switch_compat);
        switchCompat.setOnCheckedChangeListener((compoundButton, b) -> {

        });
        findViewById(R.id.viewPager).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
            startActivity(intent);
        });

    }

    public void popDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("问题：");
        builder.setMessage("请问你满十八岁了吗?");
        builder.setIcon(R.mipmap.ic_launcher_round);
        //点击对话框以外的区域是否让对话框消失
        builder.setCancelable(true);
        //设置正面按钮
        builder.setPositiveButton("是的", (dialog, which) -> {
            Toast.makeText(MainActivity.this, "你点击了是的", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        //设置反面按钮
        builder.setNegativeButton("不是", (dialog, which) -> {
            Toast.makeText(MainActivity.this, "你点击了不是", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        //设置中立按钮
        builder.setNeutralButton("保密", (dialog, which) -> {
            Toast.makeText(MainActivity.this, "你选择了保密", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        builder.show();

        builder.setNeutralButton("保密", new MyListenner());
        builder.show();
    }


    class MyListenner implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    }

}
