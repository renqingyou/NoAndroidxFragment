package com.example.renqingyou.noandroidxfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sensorsdata.analytics.android.sdk.ScreenAutoTracker;
import com.sensorsdata.analytics.android.sdk.SensorsDataTrackEvent;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity implements ScreenAutoTracker {

    public void testOnMultiChoiceClick(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        boolean[] booleans = new boolean[2];
        alertDialog.setMultiChoiceItems(0, booleans, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });

        alertDialog.setMultiChoiceItems(0, booleans, (dialog, which, isChecked) -> {

        });

    }
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
        builder.setPositiveButton("是的", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你点击了是的", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        //设置反面按钮
        builder.setNegativeButton("不是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你点击了不是", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        //设置中立按钮
        builder.setNeutralButton("保密", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你选择了保密", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.show().setOwnerActivity(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Toolbar toolbar = new Toolbar(this);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });*/
        android.support.v7.widget.Toolbar toolbar =  findViewById(R.id.toolbar);

        toolbar.setTitle("Title");
        toolbar.setTitleTextColor(Color.YELLOW);
        // 副标题
        toolbar.setSubtitle("Sub title");
        toolbar.setSubtitleTextColor(Color.parseColor("#80ff0000"));
        //侧边栏的按钮
        //取代原本的actionbar
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(menuItem -> false);

        findViewById(R.id.bt0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyFragmentActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popDialog1();
            }
        });
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyTabLayout.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.bt3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyTabHostActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.navigationView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NavigationViewActivity.class);
                startActivity(intent);
            }
        });


        //NavigationView navigationView = new NavigationView(this);
        /*navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        });*/
        //navigationView.setNavigationItemSelectedListener(menuItem -> false);

        SwitchCompat switchCompat = findViewById(R.id.switch_compat);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });


        findViewById(R.id.viewPager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void popDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("问题：");
        builder.setMessage("请问你满十八岁了吗?");
        builder.setIcon(R.mipmap.ic_launcher_round);
        //点击对话框以外的区域是否让对话框消失
        builder.setCancelable(true);
        //设置正面按钮
        builder.setPositiveButton("是的", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你点击了是的", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        //设置反面按钮
        builder.setNegativeButton("不是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你点击了不是", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        //设置中立按钮
        builder.setNeutralButton("保密", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你选择了保密", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.show();
    }

    @Override
    public String getScreenUrl() {
        return null;
    }

    @Override
    public JSONObject getTrackProperties() throws JSONException {
        JSONObject message = new JSONObject();
        //message.put("$title","TrackPropertiesTitle");
        //message.put("$screen_url","TrackScreenURL");
        return message;
    }
}
