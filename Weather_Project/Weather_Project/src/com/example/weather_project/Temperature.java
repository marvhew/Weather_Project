package com.example.weather_project;

import java.io.Serializable;

public class Temperature  implements Serializable{
	public long day,min,max,night,eve,morn;
	
	public Temperature(long day, long min, long max, long night, long eve, long morn)
	{
		this.day=day;
		this.min=min;
		this.max=max;
		this.night=night;
		this.eve=eve;
		this.morn=morn;
	}
}