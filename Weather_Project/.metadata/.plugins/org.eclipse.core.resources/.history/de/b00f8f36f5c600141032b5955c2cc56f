package com.example.weather_project;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	private final int DaysCount = 10;

	City city;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void Btn_Load_Click(View v) {
		CreateProgressBar();
		ChangeEnabled();
		EditText TxtView = (EditText) findViewById(R.id.Edit_City);
		String cityName = TxtView.getText().toString().trim().replace(' ', '_');
		TxtView = (EditText) findViewById(R.id.Edit_Country);
		String countryShort = TxtView.getText().toString().trim()
				.replace(' ', '_');
		city = new City(cityName, (countryShort.isEmpty())?"PL":countryShort);
		ashelp help = new ashelp();
		help.execute();
	}

	public void CreateProgressBar() {
		ProgressBar Pgr = new ProgressBar(this);
		Pgr.setId(054);
		RelativeLayout main = (RelativeLayout) findViewById(R.id.Lyt_Main);
		main.addView(Pgr);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);
		Pgr.setLayoutParams(params);
	}

	public void RemoveProgressBar() {
		View Pgr = findViewById(054);
		if (Pgr != null)
			((ViewGroup) Pgr.getParent()).removeView(Pgr);
	}

	public void ChangeEnabled() {
		ViewGroup main = (ViewGroup) findViewById(R.id.Lyt_Main);
		for (int i = 0; i < main.getChildCount(); i++) {
			main.getChildAt(i).setEnabled(!main.getChildAt(i).isEnabled());
		}
	}

	public void End() {
		while (!city.getIsLoaded())
			;
		if (city.isForecastNull()) {
			Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT)
					.show();
		} else {
			StartCityActivity();
		}
		RemoveProgressBar();
		ChangeEnabled();
	}

	public void StartCityActivity() {
		Intent intent = new Intent(this, CityActivity.class);
		intent.putExtra("City", city);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class ashelp extends AsyncTask<City, Void, City> {

		@Override
		protected City doInBackground(City... params) {
			// TODO Auto-generated method stub
			while (!city.getIsLoaded())
				;
			return null;
		}

		@Override
		protected void onPostExecute(City result) {
			// TODO Auto-generated method stub
			End();
			super.onPostExecute(result);
		}
	}

}
