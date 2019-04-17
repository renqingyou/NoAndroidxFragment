package com.example.renqingyou.noandroidxfragment;

import android.os.Bundle;
import android.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyFragment2 extends ListFragment {
    private static final String TAG = "rqy";

    String[] classes = {
            "计算机网络",
            "操作系统",
            "C语言",
            "Java",
            "数据库原理",
            "移动开发",
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment2, container, false);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        // 设置ListFragment默认的ListView，即@id/android:list
        this.setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, classes));

    }

    public void onListItemClick(ListView parent, View v,
                                int position, long id) {
        Log.d(TAG, "onListItemClick--"+position);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.e("rqy","fragment2--setUserVisibleHint");
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.e("rqy","fragment2--onHiddenChanged");
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onResume() {
        Log.e("rqy","fragment2--onResume");
        super.onResume();
    }
}
