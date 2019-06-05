package com.example.renqingyou.noandroidxfragment;

import android.util.Log;

public class Test {
    public void testHookMethod(){
        new Test().test(a1 -> {

        });
    }
    public void test(A<String> a){
        Log.e("rqy","a="+a);
    }
    public interface A<T> {
        void test(T a);
    }
}

class B implements Test.A{

    @Override
    public void test(Object a) {

    }
}
