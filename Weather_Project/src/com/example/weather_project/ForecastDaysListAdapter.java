package com.example.weather_project;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ForecastDaysListAdapter extends ArrayAdapter<DayForecast> {
	private Context context;
	private int layoutResourceID;
	private DayForecast data[];

	public ForecastDaysListAdapter(Context _context, int _layoutRes,
			DayForecast _data[]) {
		super(_context, _layoutRes, _data);
		context = _context;
		layoutResourceID = _layoutRes;
		data = _data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View row = convertView;
		RowHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceID, parent, false); 

			holder = new RowHolder();
			holder.RowDate = (TextView) row.findViewById(R.id.Txt_Date);
			holder.RowPressure = (TextView) row.findViewById(R.id.Txt_Pressure);
			holder.RowPrecipitation = (TextView) row.findViewById(R.id.Txt_Precipitation);
			holder.RowTemperature = (TextView) row.findViewById(R.id.Txt_Temperature);
			row.setTag(holder); 

		} else {
			holder = (RowHolder) row.getTag();
		}

		DayForecast item = data[position];
		holder.RowDate.setText(item.getDateAsString());
		holder.RowPressure.setText(item.getPressureAsString()+"hPA");
		holder.RowPrecipitation.setText(item.getPrecipitationAsString());
		holder.RowTemperature.setText(item.getTemperatureAsString()+"�C");

		return row;
	}

	static class RowHolder {
		TextView RowDate;
		TextView RowPressure;
		TextView RowPrecipitation;
		TextView RowTemperature;
	}
}