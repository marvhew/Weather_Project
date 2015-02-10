package com.example.weather_project;

import java.sql.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {
	public static DayForecast[] ParseForecast(JSONObject object, int DaysCount){
		DayForecast[] forecastTab = null;
		JSONArray lists = object.optJSONArray("list");
		if (lists != null) {
			forecastTab = new DayForecast[DaysCount];
			for (int i = 0; i < DaysCount; i++) {
				forecastTab[i] = ParseDay(lists.optJSONObject(i));
			}
		}
		return forecastTab;
	}

	private static DayForecast ParseDay(JSONObject object) {
		DayForecast forecast = null;
		forecast = new DayForecast(ParseTemperature(object.optJSONObject("temp")),ParseWeather(object.optJSONArray("weather")),new Date(object.optLong("dt")),object.optLong("pressure"),object.optLong("speed"),object.optLong("rain"),object.optLong("snow"),object.optInt("humidity"),object.optInt("deg"),object.optInt("clouds"));
		
		return forecast;
	}

	private static Weather ParseWeather(JSONArray array){
		JSONObject object = null;
		Weather weather = null;
		if(array!=null)
		object = array.optJSONObject(0);
		if(object!=null)
		weather = new Weather(object.optInt("ID"),
				object.optString("main"), object.optString("description"),
				object.optString("icon"));
		return weather;
	}

	private static Temperature ParseTemperature(JSONObject object){
		Temperature temperature = null;
		if(object!=null)
		temperature = new Temperature(object.optLong("day"),
				object.optLong("min"), object.optLong("max"),
				object.optLong("night"), object.optLong("eve"),
				object.optLong("morn"));
		return temperature;
	}
}
// Stalker
// Liam
// Horisont