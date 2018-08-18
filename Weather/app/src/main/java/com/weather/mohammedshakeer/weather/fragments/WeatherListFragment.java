package com.weather.mohammedshakeer.weather.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.weather.mohammedshakeer.weather.R;
import com.weather.mohammedshakeer.weather.adapter.WeatherListAdapter;
import com.weather.mohammedshakeer.weather.helper.ApiInterface;
import com.weather.mohammedshakeer.weather.helper.ApiUtils;
import com.weather.mohammedshakeer.weather.model.Item;
import com.weather.mohammedshakeer.weather.model.Weather;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MohammedShakeer on 18/08/18.
 */

public class WeatherListFragment extends android.support.v4.app.Fragment {

    private ApiInterface apiInterface;

    private WeatherListAdapter weatherListAdapter;

    private RecyclerView mRecyclerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiInterface = ApiUtils.getWeather();

        loadWeatherData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weather_list_view,
                container, false);

        mRecyclerView = view.findViewById(R.id.recycler_view);
        weatherListAdapter = new WeatherListAdapter( getContext(), new ArrayList<Item>(), new WeatherListAdapter.PostItemListener() {

            @Override
            public void onPostClick(Item item) {
                pushWeatherDetailsFragment(item);

            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(weatherListAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        return view;
    }

    public void loadWeatherData() {
        apiInterface.getWeather().enqueue(new Callback<Weather>() {

            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if(response.isSuccessful()) {
                    weatherListAdapter.updateWeather(response.body().getItems());
                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.d("MainActivity", "Api load failed");

            }
        });
    }


    private void pushWeatherDetailsFragment(Item item) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager()
                .beginTransaction();
        WeatherDetailsFragment weatherDetailsFragment = new WeatherDetailsFragment();
                weatherDetailsFragment.item = item;

        fragmentTransaction.replace(R.id.fragment_container, weatherDetailsFragment, WeatherDetailsFragment.class.getCanonicalName());//R.id.content_frame is the layout you want to replace
        fragmentTransaction.addToBackStack(null); // dont include this for your first fragment.
        fragmentTransaction.commit();
    }

}
