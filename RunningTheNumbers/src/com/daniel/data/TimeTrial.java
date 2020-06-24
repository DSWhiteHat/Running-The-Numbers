package com.daniel.data;

import java.util.ArrayList;

public class TimeTrial
{
	private String name;
	private Date date;
	private ArrayList<Run> performances;

	public TimeTrial(String name, Date date)
	{
		this.name = name;
		this.date = date;
		performances = new ArrayList<Run>();
	}

	public String toString()
	{
		return name + ", " + date;
	}

	public String getName()
	{
		return name;
	}

	public Date getDate()
	{
		return date;
	}

	public ArrayList<Run> getPerformances()
	{
		return performances;
	}
}
