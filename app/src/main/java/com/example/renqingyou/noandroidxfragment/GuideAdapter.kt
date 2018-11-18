package com.example.renqingyou.noandroidxfragment

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class GuideAdapter//构造函数
(private val mContext: Context) : PagerAdapter() {
    //图片资源合集:ViewPager滚动的页面种类
    val imageId = intArrayOf(R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3)

    //返回填充ViewPager页面的数量
    override fun getCount(): Int {
        return imageId.size
    }

    //销毁ViewPager内某个页面时调用
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`//固定是view == object
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(mContext)
        //设置背景资源
        imageView.setBackgroundResource(imageId[position])
        container.addView(imageView)
        return imageView
    }
}
