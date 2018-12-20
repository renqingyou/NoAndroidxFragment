package com.example.renqingyou.noandroidxfragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class GuideAdapter extends PagerAdapter {
    //图片资源合集:ViewPager滚动的页面种类
    private int[] mImageId = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
    private Context mContext;

    public int[] getImageId() {
        return mImageId;
    }
    //构造函数
    public GuideAdapter(Context context) {
        super();
        this.mContext = context;
    }
    //返回填充ViewPager页面的数量
    @Override
    public int getCount() {
        return mImageId.length;
    }
    //销毁ViewPager内某个页面时调用
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;//固定是view == object
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        //设置背景资源
        imageView.setBackgroundResource(mImageId[position]);
        container.addView(imageView);
        return imageView;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "MyPage Title";
    }
}
