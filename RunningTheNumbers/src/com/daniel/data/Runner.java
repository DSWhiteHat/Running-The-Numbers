package com.daniel.data;

import java.util.ArrayList;
import java.util.List;

public class Runner
{
	private String name;
	private Team team;
	private List<Integer> years;
	private List<Run> performances;

	public Runner(String name, Team team)
	{
		this.name = name;
		this.setTeam(team);
		setYears(new ArrayList<Integer>());
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

		int year = Integer.parseInt((performance.getMeet().getDate().toString().split("/"))[2]);

		if (!years.contains(year))
		{
			years.add(year);
		}
	}

	//Equal by name and years on the team.
	public boolean equals(String name, int year)
	{
		if(this.name.contains(" "))
		{
			String[] split = name.split(" ");
		}
		if(name.contains(" "))
		{
			String[] split = name.split(" ");
		}
		
		return true;
	}

	public String getName()
	{
		return name;
	}

	public Team getTeam()
	{
		return team;
	}

	public void setTeam(Team team)
	{
		this.team = team;
	}

	public List<Integer> getYears()
	{
		return years;
	}

	public void setYears(List<Integer> years)
	{
		this.years = years;
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
