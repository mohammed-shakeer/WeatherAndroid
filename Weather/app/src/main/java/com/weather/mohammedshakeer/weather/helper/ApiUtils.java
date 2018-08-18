package com.weather.mohammedshakeer.weather.helper;

/**
 * Created by MohammedShakeer on 18/08/18.
 */

public class ApiUtils {

    public static final String BASE_URL = "https://api.openweathermap.org";

    public static ApiInterface getWeather() {
        return RetroClient.getClient(BASE_URL).create(ApiInterface.class);
    }
}