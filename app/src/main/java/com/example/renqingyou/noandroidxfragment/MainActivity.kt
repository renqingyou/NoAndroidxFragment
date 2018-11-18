package com.example.renqingyou.noandroidxfragment

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SwitchCompat
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.bt1).setOnClickListener { popDialog1() }
        findViewById<View>(R.id.bt2).setOnClickListener {
            val intent = Intent(this@MainActivity, MyTabLayout::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.navigationView).setOnClickListener {
            val intent = Intent(this@MainActivity, NavigationViewActivity::class.java)
            startActivity(intent)
        }


        //NavigationView navigationView = new NavigationView(this);
        /*navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        });*/
        //navigationView.setNavigationItemSelectedListener(menuItem -> false);

        val switchCompat = findViewById<SwitchCompat>(R.id.switch_compat)
        switchCompat.setOnCheckedChangeListener { compoundButton, b -> }

        switchCompat.setOnCheckedChangeListener { compoundButton, b ->

        }

        findViewById<View>(R.id.viewPager).setOnClickListener {
            val intent = Intent(this@MainActivity, ViewPagerActivity::class.java)
            startActivity(intent)
        }

    }

    /**
     * 提示对话框
     */
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

        builder.show().ownerActivity = this

    }


    /**
     * 提示对话框
     */
    fun popDialog1() {
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

        builder.show().ownerActivity = this

    }


}
