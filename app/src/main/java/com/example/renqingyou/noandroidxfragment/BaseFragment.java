package com.example.renqingyou.noandroidxfragment;

import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {
    @Override
    public void onResume() {
        super.onResume();
        //SensorsDataAPI.sharedInstance().trackViewScreen(this);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    }
}
