package com.example.renqingyou.noandroidxfragment

//import android.app.Fragment;
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.sensorsdata.analytics.android.sdk.SensorsDataAPI
import com.sensorsdata.analytics.android.sdk.SensorsDataTrackFragmentAppViewScreen


@SensorsDataTrackFragmentAppViewScreen
class TestFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_test, container, false)
        val button = view.findViewById<AppCompatButton>(R.id.button)
        button.setOnClickListener { view ->
            Toast.makeText(view.context, "我是fragment上的button", Toast.LENGTH_SHORT).show()
            //SensorsDataAPI.sharedInstance().trackViewScreen();
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        //SensorsDataAPI.sharedInstance().trackViewScreen(this);
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
    }
}
