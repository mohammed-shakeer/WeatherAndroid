package com.weather.mohammedshakeer.weather.model;

import android.content.ClipData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by MohammedShakeer on 18/08/18.
 */

public class Weather {

    public List<Item> getItems() {
        return items;
    }

    @SerializedName("list")
    @Expose
    private List<Item> items = null;


}
