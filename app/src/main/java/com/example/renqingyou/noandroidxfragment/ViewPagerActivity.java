package com.example.renqingyou.noandroidxfragment;

import android.os.Bundle;

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
        /*mGuideVp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("rqy","viewPager");
            }
        });*/
    }
}
