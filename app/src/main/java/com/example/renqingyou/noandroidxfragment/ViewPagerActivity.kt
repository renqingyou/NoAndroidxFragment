package com.example.renqingyou.noandroidxfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager


class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)
        val mGuideVp = findViewById<ViewPager>(R.id.vp_guide_guide)
        val mGuideAdapter = GuideAdapter(this)
        mGuideVp.adapter = mGuideAdapter
        mGuideVp.setOnClickListener { Log.e("rqy", "viewPager") }

        mGuideVp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                Log.e("rqy", "axxx")
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }
}
