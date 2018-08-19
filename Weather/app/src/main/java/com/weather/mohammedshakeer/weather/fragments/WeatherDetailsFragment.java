package com.weather.mohammedshakeer.weather.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weather.mohammedshakeer.weather.R;
import com.weather.mohammedshakeer.weather.model.Item;

/**
 * Created by MohammedShakeer on 18/08/18.
 */

public class WeatherDetailsFragment extends android.support.v4.app.Fragment {

    public Item item;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weather_details,
                container, false);

        ((TextView)view.findViewById(R.id.textViewTemp)).setText(item.getMain().getTemp());
        ((TextView)view.findViewById(R.id.textViewDate)).setText(item.getDate());
        ((TextView)view.findViewById(R.id.textViewDesc)).setText(item.getDescription().get(0).getDescription());
        ((TextView)view.findViewById(R.id.textViewTempRange)).setText(item.getMain().getTemp_range());
        ((TextView)view.findViewById(R.id.textViewHumidity)).setText(item.getMain().getHumidity());
        ((TextView)view.findViewById(R.id.textViewDefault)).setText(item.getMain().getDefaultPressure());
        ((TextView)view.findViewById(R.id.textViewSeaLevel)).setText(item.getMain().getSeaLevel());
        ((TextView)view.findViewById(R.id.textViewGroundLevel)).setText(item.getMain().getGroundLevel());
        ((TextView)view.findViewById(R.id.textViewSpeed)).setText(item.getWind().getSpeed());
        ((TextView)view.findViewById(R.id.textViewDegree)).setText(item.getWind().getDegree());

        return view;
    }

}
