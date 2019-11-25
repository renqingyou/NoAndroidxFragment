package com.example.renqingyou.noandroidxfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle;

@SensorsDataFragmentTitle(title="我是 MyFragment")
public class MyFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1,container,false);
        return v;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.e("rqy","fragment1--setUserVisibleHint");
        super.setUserVisibleHint(isVisibleToUser);
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.e("rqy","fragment1--onHiddenChanged");
        super.onHiddenChanged(hidden);
    }

    public void setUserVisibleHint() {
        Log.e("rqy","fragment1--onResume");
        super.onResume();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
