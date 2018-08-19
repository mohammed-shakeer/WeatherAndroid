package com.weather.mohammedshakeer.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.weather.mohammedshakeer.weather.fragments.WeatherListFragment;

public class MainActivity extends AppCompatActivity {

    public boolean isCelsius = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pushWeatherListFragment();
    }

    private void pushWeatherListFragment() {

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        WeatherListFragment weatherListFragment = new WeatherListFragment();
        fragmentTransaction.add(R.id.fragment_container, weatherListFragment, WeatherListFragment.class.getCanonicalName());//R.id.content_frame is the layout you want to replace
        fragmentTransaction.commit();
    }

}
