package com.example.renqingyou.noandroidxfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class ViewPagerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        ViewPager mGuideVp = (ViewPager)findViewById(R.id.vp_guide_guide);
        GuideAdapter mGuideAdapter = new GuideAdapter(this);
        mGuideVp.setAdapter(mGuideAdapter);
        /*mGuideVp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("rqy","viewPager");
            }
        });*/
    }
}
