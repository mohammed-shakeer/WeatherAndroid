package com.weather.mohammedshakeer.weather.utils;

import com.weather.mohammedshakeer.weather.MainActivity;

import java.text.DecimalFormat;

/**
 * Created by MohammedShakeer on 19/08/18.
 */

public class Utils {

    public static String tempValue(String value, boolean isCelsius) {
        String temp = isCelsius ? value : Fahrenheit(32 + (1.8 * Double.parseDouble(value))) ;
        return temp + "º";
    }

    public static String Fahrenheit(Double aDouble) {

        DecimalFormat dec = new DecimalFormat("#0.00");
        return dec.format(aDouble);
    }

    public static String tempRangeValue(String min, String max, boolean isCelsius) {
        String minTemp = isCelsius ? min : Fahrenheit(32 + (1.8 * Double.parseDouble(min))) ;
        String maxTemp = isCelsius ? max : Fahrenheit(32 + (1.8 * Double.parseDouble(max))) ;

        return "Max: " + maxTemp + "º, Min: " + minTemp + "º";
    }

}
