package com.weather.mohammedshakeer.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by MohammedShakeer on 18/08/18.
 */

public class Item {

    @SerializedName("dt_txt")
    @Expose
    private String date;

    @SerializedName("main")
    @Expose
    private Main main;

    @SerializedName("wind")
    @Expose
    private Wind wind;

    @SerializedName("weather")
    @Expose
    private List<Description> description;

    public String getDate() {
        return date;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public List<Description> getDescription() {
        return description;
    }
}
