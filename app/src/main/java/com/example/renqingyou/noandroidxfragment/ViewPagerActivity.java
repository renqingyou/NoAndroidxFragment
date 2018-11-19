package com.example.renqingyou.noandroidxfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


public class ViewPagerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        ViewPager mGuideVp = findViewById(R.id.vp_guide_guide);
        GuideAdapter mGuideAdapter = new GuideAdapter(this);
        mGuideVp.setAdapter(mGuideAdapter);
        mGuideVp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("rqy","viewPager");
            }
        });

        mGuideVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                      Log.e("rqy","axxx");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
