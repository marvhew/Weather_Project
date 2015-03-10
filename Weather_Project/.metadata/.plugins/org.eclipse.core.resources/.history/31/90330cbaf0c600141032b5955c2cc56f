package com.example.weather_project;

import java.io.Serializable;

public class Weather implements Serializable {
	private int ID;
	private String main;
	private String description;
	private String iconID;
	public Weather(int ID, String main, String description, String iconID)
	{
		this.ID=ID;
		this.main=main;
		this.description=description;
		this.iconID=iconID;
	}
	
	public String getShort()
	{
		return main;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getImageURL()
	{
		return "http://openweathermap.org/img/w/"+iconID+".png";
	}
}
/*    "id":600,
"main":"Snow",
"description":"light snow",
"icon":"13d"*/