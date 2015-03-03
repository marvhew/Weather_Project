package com.example.weather_project;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void Btn_Load_Click(View v)
	{
		CreateProgressBar();
		ChangeEnabled();
		EditText TxtView = (EditText) findViewById(R.id.Edit_City);
		City city = new City(TxtView.getText().toString().trim().replace(' ', '_'));
		ashelp help = new ashelp();
		help.execute(city);
	}
	
	public void CreateProgressBar()
	{
		ProgressBar Pgr = new ProgressBar(this);
		Pgr.setId(054);
		RelativeLayout main = (RelativeLayout) findViewById(R.id.Lyt_Main);
		main.addView(Pgr);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);
		Pgr.setLayoutParams(params);
	}
	
	public void RemoveProgressBar()
	{
		View Pgr = findViewById(054);
		if(Pgr!=null)
			((ViewGroup)Pgr.getParent()).removeView(Pgr);
	}
	
	public void ChangeEnabled()
	{
		ViewGroup main = (ViewGroup) findViewById(R.id.Lyt_Main);
		for(int i=0; i<main.getChildCount();i++)
		{
			main.getChildAt(i).setEnabled(!main.getChildAt(i).isEnabled());
		}
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
		RemoveProgressBar();
		ChangeEnabled();
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
