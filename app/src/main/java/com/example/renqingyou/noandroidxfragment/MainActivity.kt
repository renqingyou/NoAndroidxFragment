package com.example.renqingyou.noandroidxfragment

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.viewpager.widget.ViewPager

import android.view.View
import android.widget.CompoundButton
import android.widget.Toast

import com.sensorsdata.analytics.android.sdk.SensorsDataTrackEvent


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.bt).setOnClickListener { popDialog() }

        findViewById<View>(R.id.tabLayout).setOnClickListener {
            val intent = Intent(this@MainActivity, MyTabLayout::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.navigation).setOnClickListener {
            val intent = Intent(this@MainActivity, NavigationViewActivity::class.java)
            startActivity(intent)
        }

        val switchCompat = findViewById<SwitchCompat>(R.id.switch_compat)
        switchCompat.setOnCheckedChangeListener { compoundButton, b -> }

        findViewById<View>(R.id.viewpager).setOnClickListener {
            val intent = Intent(this@MainActivity, ViewPagerActivity::class.java)
            startActivity(intent)
        }


    }

    /**
     * 提示对话框
     */
    @SensorsDataTrackEvent(eventName = "someEventName", properties = "{\"provider\":\"神策数据\",\"number\":100,\"isLogin\":true}")
    fun popDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("问题：")
        builder.setMessage("请问你满十八岁了吗?")
        builder.setIcon(R.mipmap.ic_launcher_round)
        //点击对话框以外的区域是否让对话框消失
        builder.setCancelable(true)
        //设置正面按钮
        builder.setPositiveButton("是的") { dialog, which ->
            Toast.makeText(this@MainActivity, "你点击了是的", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        //设置反面按钮
        builder.setNegativeButton("不是") { dialog, which ->
            Toast.makeText(this@MainActivity, "你点击了不是", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        //设置中立按钮
        builder.setNeutralButton("保密") { dialog, which ->
            Toast.makeText(this@MainActivity, "你选择了保密", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        //两种方式显示Dialog

        /*AlertDialog dialog = builder.create();
        //对话框显示的监听事件
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Log.e("rqy","对话框显示了");
            }
        });
        //对话框消失的监听事件
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Log.e("rqy","对话框消失了");
            }
        });
        //显示对话框
        dialog.show();*/

        builder.show()

    }
}
