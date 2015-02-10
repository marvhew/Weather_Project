package com.example.weather_project;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {
	private final int DaysCount = 10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		City city = new City("Krak�w");
		ashelp help = new ashelp();
		help.execute(city);
	}
	
	public void End(City city)
	{
		String message;
		while (!city.getIsLoaded())
			;
		if (city.isForecastNull()) {
			message = "Something went wrong";
		} else {
			message = "Should work";
		}
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class ashelp extends AsyncTask<City, Void, City>{

		@Override
		protected City doInBackground(City... params) {
			// TODO Auto-generated method stub
			while(!params[0].getIsLoaded());
			return params[0];
		}
		@Override
		protected void onPostExecute(City result) {
			// TODO Auto-generated method stub
			End(result);
			super.onPostExecute(result);
		}
	} 

}
