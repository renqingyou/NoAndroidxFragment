package com.example.renqingyou.noandroidxfragment

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity


class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)
        val mGuideVp = findViewById<ViewPager>(R.id.vp_guide_guide)
        val mGuideAdapter = GuideAdapter(this)
        mGuideVp.adapter = mGuideAdapter
        /*mGuideVp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("rqy","viewPager");
            }
        });*/

        mGuideVp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {

            }
        })
    }
}
