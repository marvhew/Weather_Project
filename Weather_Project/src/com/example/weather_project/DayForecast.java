package com.example.weather_project;

import java.io.Serializable;
import java.sql.Date;

import org.json.JSONObject;

public class DayForecast implements Serializable{
	Temperature temperature;
	Weather weather;
	Date dt;
	long pressure,speed,rain,snow;
	int humidity,deg,clouds;
	
	public DayForecast(Temperature temperature, Weather weather, Date dt, long pressure, long speed, long rain, long snow, int humidity, int deg, int clouds)
	{
		this.temperature=temperature;
		this.weather=weather;
		this.dt=dt;
		this.deg=deg;
		this.pressure=pressure;
		this.speed=speed;
		this.rain=rain;
		this.snow=snow;
		this.humidity=humidity;
		this.clouds=clouds;
	}
}
