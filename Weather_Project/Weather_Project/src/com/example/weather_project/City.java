package com.example.weather_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class City implements Serializable {
	private int DaysCount;
	private String name;
	private String usersName;
	private String country;
	private DayForecast[] forecast;
	private boolean isLoaded;

	public City(String name, String country, int DaysCount) {
		this.DaysCount = DaysCount;
		usersName = name + "," + country;
		this.isLoaded = false;
		getJSON();
	}

	public City(String name) {
		this(name, "PL", 10);
	}

	public City(String name, String country) {
		this(name, country, 10);
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public boolean isForecastNull() {
		return (forecast == null) ? true : false;
	}

	public boolean getIsLoaded() {
		return isLoaded;
	}

	public DayForecast[] getForecast() {
		return forecast;
	}

	public int GetDaysCount() {
		return forecast.length;
	}

	public DayForecast GetDayForecast(int index) {
		DayForecast dayForecast = (index > 0) ? (forecast.length > index) ? forecast[index]
				: null
				: null;
		return dayForecast;

	}

	private void getJSON() {
		JSONAsyncTask task = new JSONAsyncTask();
		task.execute("http://api.openweathermap.org/data/2.5/forecast/daily?q="
				+ usersName + "&cnt=" + DaysCount
				+ "&mode=json&units=metric&type=accurate");
	}

	private void ParseJSON(String JSONString) {
		try {
			JSONObject object = new JSONObject(JSONString);
			forecast = JSONParser.ParseForecast(object, DaysCount);
			object = object.optJSONObject("city");
			if (object != null) {
				name = object.optString("name");
				country = object.optString("country");
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forecast = null;
		} finally {
			isLoaded = true;
		}
	}

	private class JSONAsyncTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			InputStream is = null;
			String json = "";
			String stringURL = params[0];
			try {
				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(stringURL);
				HttpResponse httpResponse = httpClient.execute(httpPost);
				HttpEntity httpEntity = httpResponse.getEntity();
				is = httpEntity.getContent();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
				return e.toString();
			} catch (IOException e) {
				e.printStackTrace();
				return e.toString();
			}

			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is, "UTF-8"));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				is.close();
				json = sb.toString();
				return json;
			} catch (Exception e) {
				Log.e("Buffer Error", "error converting result " + e.toString());
				return e.toString();
			}
		}

		@Override
		protected void onPostExecute(String result) {
			ParseJSON(result);
			super.onPostExecute(result);
		}

	}
}
