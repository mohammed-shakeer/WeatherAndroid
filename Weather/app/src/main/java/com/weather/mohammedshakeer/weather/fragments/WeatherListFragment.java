package com.weather.mohammedshakeer.weather.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.weather.mohammedshakeer.weather.MainActivity;
import com.weather.mohammedshakeer.weather.R;
import com.weather.mohammedshakeer.weather.adapter.WeatherListAdapter;
import com.weather.mohammedshakeer.weather.helper.ApiInterface;
import com.weather.mohammedshakeer.weather.helper.ApiUtils;
import com.weather.mohammedshakeer.weather.model.Item;
import com.weather.mohammedshakeer.weather.model.Weather;
import com.weather.mohammedshakeer.weather.utils.NotificationHelper;

import java.util.ArrayList;
import java.util.List;

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

    private List<Item> items = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        apiInterface = ApiUtils.getWeather();
        loadWeatherData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weather_list_view,
                container, false);

        mRecyclerView = view.findViewById(R.id.recycler_view);
        weatherListAdapter = new WeatherListAdapter(this, items, new WeatherListAdapter.PostItemListener() {

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


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);

        setMenuItemTitle(menu.getItem(0));
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_status:
                setMenuItemTitle(item);
                switchTempUnit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setMenuItemTitle(MenuItem item) {
        String title =  ((MainActivity)getActivity()).isCelsius ? "Fahrenheit" : "Celsius";
        item.setTitle(title);
    }

    private void switchTempUnit() {
        weatherListAdapter.notifyDataSetChanged();
        ((MainActivity)getActivity()).isCelsius = !((MainActivity)getActivity()).isCelsius;
    }
    public void loadWeatherData() {
        apiInterface.getWeather().enqueue(new Callback<Weather>() {

            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if(response.isSuccessful()) {
                    weatherListAdapter.updateWeather(response.body().getItems());
                    notifyUser(response.body().getItems().get(0));
                    items = response.body().getItems();
                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
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
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void notifyUser(Item item) {
        NotificationHelper notificationHelper = new NotificationHelper(getActivity());
        notificationHelper.createNotification(item.getMain().getTemp(),item.getDescription().get(0).getDescription());
    }

}
