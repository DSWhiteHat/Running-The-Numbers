package com.daniel.data;

import java.util.List;

public class Run implements Comparable<Run>
{
	private TimeTrial meet;
	private String runner;
	
	//Lists store times and places for splits and finish.
	private List<Time> times;
	private int teamPlace;
	private List<Integer> places;

	public Run(String runner, List<Time> times, Meet meet, int teamPlace, List<Integer> places)
	{
		this.meet = meet;
		this.runner = runner;
		this.times = times;
		this.teamPlace = teamPlace;
		this.places = places;
	}

	public int compareTo(Run other)
	{
		return times.get(times.size() - 1).compareTo(other.getTime());
	}

	public TimeTrial getMeet()
	{
		return meet;
	}

	public String getRunner()
	{
		return runner;
	}

	public List<Time> getTimes()
	{
		return times;
	}
	
	public List<Integer> getPlaces()
	{
		return places;
	}
	
	//Finishing time / places.
	public Time getTime()
	{
		return times.get(times.size() - 1);
	}
	
	public int getTeamPlace()
	{
		return teamPlace;
	}
	
	public int getPlace()
	{
		return places.get(places.size() - 1);
	}
}
