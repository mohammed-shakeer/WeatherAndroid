package com.weather.mohammedshakeer.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MohammedShakeer on 18/08/18.
 */

public class Description {

    public String getDescription() {
        return description;
    }

    @SerializedName("description")
    @Expose
    private String description;

}
