package com.weather.mohammedshakeer.weather.helper;

import com.weather.mohammedshakeer.weather.model.Item;
import com.weather.mohammedshakeer.weather.model.Weather;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MohammedShakeer on 18/08/18.
 */

public interface ApiInterface {

    @GET("/data/2.5/forecast?q=dubai,uae&APPID=9c1dbbbd9538ec49934ecfc1d9cabd60&units=metric")
    Call<Weather> getWeather();
}
