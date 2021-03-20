package com.daniel.data;

import java.util.List;

public class Run implements Comparable<Run>
{
	private MeetSheet meet;
	private Runner runner;
	private String comments;
	
	//Arrays store times and places for splits and finish.
	private Time[] times;
	private int teamPlace;
	private int[] places;

	public Run(MeetSheet meet, Runner runner, Time[] times, int teamPlace, int[] places, String comments)
	{
		this.meet = meet;
		this.runner = runner;
		this.times = times;
		this.teamPlace = teamPlace;
		this.places = places;
		this.comments = comments;
	}

	public int compareTo(Run other)
	{
		return getTime().compareTo(other.getTime());
	}
	
	public boolean equals(Run other)
	{
		return (compareTo(other) == 0);
	}
	
	public String toString()
	{
		String out = runner.getName() + "\t\t";

		for (int j = 0; j < times.length; j++)
		{
			out += times[j] + "\t" + places[j] + "\t";
		}

		out += teamPlace + "\t" + comments + "\n";
		
		return out;
	}

	public MeetSheet getMeet()
	{
		return meet;
	}

	public Runner getRunner()
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
		for(int i = times.length - 1; i >= 0; i--)
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
	
	public String getComments()
	{
		return comments;
	}
	
	public void setComments(String comments)
	{
		this.comments = comments;
	}
}
