package com.weather.mohammedshakeer.weather;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.weather.mohammedshakeer.weather.fragments.WeatherListFragment;
import com.weather.mohammedshakeer.weather.helper.ApiInterface;
import com.weather.mohammedshakeer.weather.helper.ApiUtils;
import com.weather.mohammedshakeer.weather.model.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pushWeatherListFragment();
    }

    private void pushWeatherListFragment() {

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        WeatherListFragment weatherListFragment = new WeatherListFragment();//the fragment you want to show
        fragmentTransaction.replace(R.id.fragment_container, weatherListFragment, WeatherListFragment.class.getCanonicalName());//R.id.content_frame is the layout you want to replace
        fragmentTransaction.commit();
    }


}
