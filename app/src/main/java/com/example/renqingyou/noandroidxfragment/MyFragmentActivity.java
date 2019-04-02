package com.example.renqingyou.noandroidxfragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MyFragmentActivity extends AppCompatActivity {

        private TextView marketBar;
        private TextView hatBar;
        private TextView messageBar;
        private TextView centerBar;

        Fragment giftFragment;
        Fragment hatFragment;
        Fragment messageFragment;
        Fragment centerFragment;

        FragmentManager fragmentManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_fragment);

            marketBar = (TextView) findViewById(R.id.bar_market);
            hatBar = (TextView) findViewById(R.id.bar_hat);
            messageBar = (TextView) findViewById(R.id.bar_message);
            centerBar = (TextView) findViewById(R.id.bar_center);

            marketBar.setClickable(true);
            hatBar.setClickable(true);
            messageBar.setClickable(true);
            centerBar.setClickable(true);

            setAllNotSelected();
            marketBar.setSelected(true);

            giftFragment = new MyFragment();
            hatFragment = new MyFragment2();
            messageFragment = new MyFragment3();
            centerFragment = new MyFragment4();

            fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_fragment, giftFragment).commit();

        }


        private void setAllNotSelected() {
            marketBar.setSelected(false);
            hatBar.setSelected(false);
            messageBar.setSelected(false);
            centerBar.setSelected(false);
        }

        public void tabSelect(View v) {
            setAllNotSelected();
            switch (v.getId()) {
                case R.id.bar_market:
                    marketBar.setSelected(true);
                    fragmentManager.beginTransaction().replace(R.id.main_fragment, giftFragment).commit();
                    giftFragment.setUserVisibleHint(false);
                    break;
                case R.id.bar_hat:
                    hatBar.setSelected(true);
                    fragmentManager.beginTransaction().replace(R.id.main_fragment, hatFragment).commit();
                    break;
                case R.id.bar_message:
                    messageBar.setSelected(true);
                    fragmentManager.beginTransaction().replace(R.id.main_fragment, messageFragment).commit();

                    break;
                case R.id.bar_center:
                    centerBar.setSelected(true);
                    fragmentManager.beginTransaction().replace(R.id.main_fragment, centerFragment).commit();
                    break;
                default:
                    break;
            }
        }

}
