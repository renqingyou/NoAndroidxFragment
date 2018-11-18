package com.example.renqingyou.noandroidxfragment

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Toast


class MyTabLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tabLayout = TabLayout(this)
        tabLayout.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 60)
        //tab可滚动
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        //tab居中显示
        tabLayout.tabGravity = TabLayout.GRAVITY_CENTER
        //tab的字体选择器,默认黑色,选择时红色
        tabLayout.setTabTextColors(Color.BLACK, Color.RED)
        //tab的下划线颜色,默认是粉红色
        tabLayout.setSelectedTabIndicatorColor(Color.BLUE)
        for (i in 0..19) {
            //添加tab
            tabLayout.addTab(tabLayout.newTab().setText("TAB$i"))
        }
        val toast = Toast.makeText(this, "", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        //设置tab的点击监听器
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                toast.setText(tab.position.toString() + ":" + tab.text)
                toast.show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        tabLayout.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        setContentView(tabLayout)
    }
}
