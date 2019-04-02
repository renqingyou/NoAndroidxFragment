package com.example.renqingyou.noandroidxfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyFragment4 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment4,container,false);
        return v;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.e("rqy","fragment4--setUserVisibleHint");
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.e("rqy","fragment4--onHiddenChanged");
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onResume() {
        Log.e("rqy","fragment4--onResume");
        super.onResume();
    }
}
