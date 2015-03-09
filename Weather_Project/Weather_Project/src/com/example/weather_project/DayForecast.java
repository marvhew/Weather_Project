package com.example.weather_project;

import java.io.Serializable;
import java.sql.Date;

import org.json.JSONObject;

public class DayForecast implements Serializable{
	private Temperature temperature;
	private Weather weather;
	private Date dt;
	private double pressure,speed,rain,snow;
	private int humidity,deg,clouds;
	
	public DayForecast(Temperature temperature, Weather weather, Date dt, double pressure, double speed, double rain, double snow, int humidity, int deg, int clouds)
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
	
	public Date getDate()
	{
		return dt;
	}
	
	public String getDescription()
	{
		String input = weather.getDescription();
		return "\""+Character.toUpperCase(input.charAt(0)) + input.substring(1)+"\"";
	}
	
	public String getDateAsString()
	{
		return dt.toString();
	}
	
	public String getPressureAsString()
	{
		return ""+pressure;
	}
	
	public String getSnowAsString()
	{
		if(Double.isNaN(snow))
		{
			return "0";
		}
		else
			return ""+snow;
	}
	
	public String getRainAsString()
	{
		if(Double.isNaN(rain))
		{
			return "0";
		}
		else
			return ""+rain;
	}
	
	public String getShortDescription()
	{
		return ""+weather.getShort();
	}
	
	public String getTemperatureMinAsString()
	{
		return ""+temperature.min;
	}
	
	public String getTemperatureMaxAsString()
	{
		return ""+temperature.max;
	}
	
	public String getTemperatureMornAsString()
	{
		return ""+temperature.morn;
	}
	
	public String getTemperatureEveAsString()
	{
		return ""+temperature.eve;
	}
	
	public String getTemperatureAsString()
	{
		return ""+((temperature.min+temperature.max)/2);
	}
	
	public String getImageURL()
	{
		return weather.getImageURL();
	}
}

