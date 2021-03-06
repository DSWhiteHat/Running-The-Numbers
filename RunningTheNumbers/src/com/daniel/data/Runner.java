package com.daniel.data;

import java.util.ArrayList;
import java.util.List;

public class Runner
{
	private String name;
	private int gradYear;
	private List<School> schools;
	private List<Team> teams;
	private List<Run> performances;

	public Runner(String name, int gradYear)
	{
		this.name = name;
		this.gradYear = gradYear;
		
		schools = new ArrayList<School>();
		teams = new ArrayList<Team>();
		performances = new ArrayList<Run>();
	}

	public static Run findPR(List<Run> performances)
	{
		Run pr = performances.get(0);

		for (int i = 1; i < performances.size(); i++)
		{
			if (performances.get(i).getTime().getMinuteDecimal() < pr.getTime().getMinuteDecimal())
			{
				pr = performances.get(i);
			}
		}

		return pr;
	}

	public void addPerformance(Run performance)
	{
		performances.add(performance);

		/*
		int year = Integer.parseInt((performance.getMeet().getDate().toString().split("/"))[2]);
		
		if(years[0] == 0)
		{
			years[0] = year;
			gradYear = year + 5;
		}
		years[year - years[0]] = year;
		*/
	}

	//Equal by name and years on the team.
	/*
	public boolean equals(String name, int year)
	{
		if(year >= gradYear - 4 && year < gradYear)
		{
			if(this.name.equals(name))
			{
				return true;
			}
			
			String[] splitOne = {"", this.name};
			String[] splitTwo = {"", name};
			
			if(this.name.contains(" "))
			{
				splitOne = this.name.split(" ");
			}
			if(name.contains(" "))
			{
				splitTwo = name.split(" ");
			}
			
			if(splitOne[1].equals(splitTwo[1]))
			{
				if(splitOne[0].length() != 0 && splitTwo[0].length() != 0 && splitOne[0].charAt(0) != splitTwo[0].charAt(0))
				{
					return false;
				}
				
				if(splitOne[0].length() < splitTwo[0].length())
				{
					this.name = splitTwo[0] + " " + splitOne[1];
				}
				
				return true;
			}
		}
		
		return false;
	}
	*/
	
	public String getName()
	{
		return name;
	}

	public List<Team> getTeams()
	{
		return teams;
	}

	public void setTeam(List<Team> teams)
	{
		this.teams = teams;
	}

	public List<Run> getPerformances()
	{
		return performances;
	}

	public Run getPR()
	{
		return findPR(performances);
	}

	public Time getAverageTime()
	{
		return Time.average(performances);
	}
}
