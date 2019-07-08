package com.example.renqingyou.noandroidxfragment;
import android.view.View;

public class Test implements View.OnClickListener{

    public static void main(){
        Test test = new Test();
        test.a(v -> {
            test.myMethod(v);
        });
    }

    public static void main1(){
        Test test = new Test();
        test.a(test::myMethod);
    }

    public void a(MyListener listener) {

    }

    @Override
    public void onClick(View v) {

    }

    interface MyListener {
        void click(View v);
    }

    public void myMethod(View v) {
        System.out.println("v");
    }
}
