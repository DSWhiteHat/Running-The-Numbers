package com.daniel.data;

import java.util.ArrayList;

public class Runner
{
	private String name;
	private ArrayList<Run> performances;
	private Run pr;
	private Time averageTime;
	
	public Runner(String name)
	{
		this.name = name;
		performances = new ArrayList<Run>();
	}

	public Runner(String name, ArrayList<Run> performances)
	{
		this.name = name;
		this.performances = performances;
		averageTime = Time.average(performances);
		pr = findPR(performances);
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
		return pr;
	}

	public Time getAverageTime()
	{
		return averageTime;
	}
}
