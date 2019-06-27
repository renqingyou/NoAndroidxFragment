package com.example.renqingyou.noandroidxfragment;
import android.view.View;

public class Test {

    public static void main(){
        Test test = new Test();
        test.a(v -> {
            myMethod(v);
        });
    }

    public static void main1(){
        Test test = new Test();
        test.a(Test::myMethod);
    }

    public void a(MyListener listener) {

    }

    interface MyListener {
        void click(View v);
    }

    public static void myMethod(View v) {
        System.out.println("v");
    }
}
