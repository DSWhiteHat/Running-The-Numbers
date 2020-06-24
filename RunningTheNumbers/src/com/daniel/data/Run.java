package com.daniel.data;

import java.util.List;

public class Run implements Comparable<Run>
{
	private Meet meet;
	private Runner runner;
	
	//Lists store times and places for splits and finish.
	private List<Time> times;
	private List<Integer> teamPlaces;
	private List<Integer> places;

	public Run(Runner runner, List<Time> times, Meet meet, List<Integer> teamPlaces, List<Integer> places)
	{
		this.meet = meet;
		this.runner = runner;
		this.times = times;
		this.teamPlaces = teamPlaces;
		this.places = places;
	}

	public int compareTo(Run other)
	{
		return times.get(times.size() - 1).compareTo(other.getTime());
	}

	public Meet getMeet()
	{
		return meet;
	}

	public Runner getRunner()
	{
		return runner;
	}

	public List<Time> getTimes()
	{
		return times;
	}
	
	public List<Integer> getTeamPlaces()
	{
		return teamPlaces;
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
		return teamPlaces.get(teamPlaces.size() - 1);
	}
	
	public int getPlace()
	{
		return places.get(places.size() - 1);
	}
}
