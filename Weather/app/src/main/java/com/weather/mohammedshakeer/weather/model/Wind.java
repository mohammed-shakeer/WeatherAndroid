package com.weather.mohammedshakeer.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MohammedShakeer on 18/08/18.
 */

public class Wind {

    @SerializedName("speed")
    @Expose
    private String speed;

    @SerializedName("deg")
    @Expose
    private String deg;

    public String getSpeed() { return "Speed:  " + speed; }
    public String getDegree() { return "Degree:  " + deg; }
}
