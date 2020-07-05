package com.daniel.data;

import java.util.List;

public class Run implements Comparable<Run>
{
	private Meet meet;
	private String runner;
	
	//Lists store times and places for splits and finish.
	private Time[] times;
	private int teamPlace;
	private int[] places;

	public Run(String runner, Time[] times, Meet meet, int teamPlace, int[] places)
	{
		this.meet = meet;
		this.runner = runner;
		this.times = times;
		this.teamPlace = teamPlace;
		this.places = places;
	}

	public int compareTo(Run other)
	{
		return getTime().compareTo(other.getTime());
	}

	public Meet getMeet()
	{
		return meet;
	}

	public String getRunner()
	{
		return runner;
	}

	public Time[] getTimes()
	{
		return times;
	}
	
	public int[] getPlaces()
	{
		return places;
	}
	
	//Finishing time.
	public Time getTime()
	{
		for(int i = times.length; i >= 0; i--)
		{
			if(times[i] != null)
			{
				return times[i];
			}
		}
		
		return null;
	}
	
	//Finishing place on team
	public int getTeamPlace()
	{
		return teamPlace;
	}
	
	//Finishing place.
	public int getPlace()
	{
		for(int i = places.length; i >= 0; i--)
		{
			if(places[i] != 0)
			{
				return places[i];
			}
		}
		
		return 0;
	}
}
