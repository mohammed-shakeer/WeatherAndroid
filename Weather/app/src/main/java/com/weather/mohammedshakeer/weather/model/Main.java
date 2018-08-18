package com.weather.mohammedshakeer.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MohammedShakeer on 18/08/18.
 */

public class Main {

    @SerializedName("temp")
    @Expose
    private String temp;

    @SerializedName("temp_min")
    @Expose
    private String temp_min;

    @SerializedName("temp_max")
    @Expose
    private String temp_max;

    @SerializedName("pressure")
    @Expose
    private String pressure;

    @SerializedName("sea_level")
    @Expose
    private String sea_level;

    @SerializedName("grnd_level")
    @Expose
    private String grnd_level;

    @SerializedName("humidity")
    @Expose
    private String humidity;

    @SerializedName("temp_kf")
    @Expose
    private String temp_kf;

    public String getTemp() { return "Temperature: " + temp + "º"; }
    public String getTemp_range() { return "Max: " + temp_max + "º, Min: " + temp_min + "º"; }
    public String getHumidity() { return "Humidity " + humidity + "%"; }
    public String getPressure() {
        return pressure;
    }
    public String getDefaultPressure() { return "Default:  " + pressure + " hPa"; }
    public String getSeaLevel() { return "Sea level:  " + sea_level + " hPa"; }
    public String getGroundLevel() { return "Ground level:  " + grnd_level + " hPa"; }
    public String getTemp_kf() {
        return temp_kf;
    }

}
