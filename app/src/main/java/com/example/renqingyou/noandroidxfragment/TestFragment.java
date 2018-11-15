package com.example.renqingyou.noandroidxfragment;

//import android.app.Fragment;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sensorsdata.analytics.android.sdk.SensorsDataTrackFragmentAppViewScreen;


@SuppressWarnings("Convert2Lambda")
@SensorsDataTrackFragmentAppViewScreen
public class TestFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        AppCompatButton button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"我是fragment上的button",Toast.LENGTH_SHORT).show();
                //SensorsDataAPI.sharedInstance().trackViewScreen();
            }
        });
        return view;
    }

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
}
