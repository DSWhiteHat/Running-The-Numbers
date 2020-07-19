package com.daniel.data;

import java.util.ArrayList;

public class Runner
{
	private String name;
	private ArrayList<Run> performances;
	
	public Runner(String name)
	{
		this.name = name;
		performances = new ArrayList<Run>();
	}

	public Runner(String name, ArrayList<Run> performances)
	{
		this.name = name;
		this.performances = performances;
	}
	
	public static Run findPR(ArrayList<Run> performances)
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
	
	public boolean equals(Runner other)
	{
		return (name.equals(other.getName()) && performances.equals(other.getPerformances()));
	}

	public String getName()
	{
		return name;
	}

	public ArrayList<Run> getPerformances()
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
