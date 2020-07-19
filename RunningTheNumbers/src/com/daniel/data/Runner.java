package com.daniel.data;

import java.util.ArrayList;
import java.util.List;

import com.daniel.main.Main;

public class Runner
{
	private String name;
	private List<Integer> years;
	private List<Run> performances;
	
	public Runner(String name)
	{
		this.name = name;
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
		
		if(!years.contains(year))
		{
			years.add(year);
		}
	}
	
	public boolean equals(Runner other)
	{
		return (name.equals(other.getName()) && performances.equals(other.getPerformances()));
	}

	public String getName()
	{
		return name;
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
