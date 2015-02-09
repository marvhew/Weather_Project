package com.example.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

public class City {
	private final int DaysCount = 10;
	private String name;
	private DayForecast[] forecast;
	public City(String name)
	{
		this.name = name;
		getJSON();
	}
	private void getJSON()
	{
		JSONAsyncTask task = new JSONAsyncTask();
		task.execute("http://api.openweathermap.org/data/2.5/forecast/daily?q="+name+"&cnt="+DaysCount+"&mode=json&units=metric");
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
			super.onPostExecute(result);
		}

	}
}
