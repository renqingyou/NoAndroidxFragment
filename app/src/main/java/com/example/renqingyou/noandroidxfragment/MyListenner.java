package com.example.renqingyou.noandroidxfragment;

import android.util.Log;

public class MyListenner {
    public void test(A a){
        Log.e("rqy","a="+a);
    }
    public interface A {
        void test(String a);
    }
}
