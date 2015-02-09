package com.example.project;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {
	public static DayForecast[] Parse(JSONObject object, int DaysCount) {
		DayForecast[] tab = null;
		JSONArray lists = object.optJSONArray("list");
		if (lists != null) {
			tab = new DayForecast[DaysCount];
			for (int i = 0; i < DaysCount; i++) {
				try {
					tab[i] = ParseDay(lists.getJSONObject(i));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return tab;
	}

	private static DayForecast ParseDay(JSONObject object) {
		
		return null;
	}
}
