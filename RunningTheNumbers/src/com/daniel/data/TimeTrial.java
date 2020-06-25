package com.daniel.data;

import java.util.ArrayList;
import java.util.List;

public class TimeTrial
{
	private String name;
	private Date date;
	private String conditions;
	private String comments;
	private List<Run> performances;

	public TimeTrial(String name, Date date, String conditions, String comments)
	{
		this.name = name;
		this.date = date;
		this.setConditions(conditions);
		this.setComments(comments);
		performances = new ArrayList<Run>();
	}

	public String toString()
	{
		String out = name + ", " + date + "\n" + conditions + "\n" + comments + "\n";
		
		out += "Performances: \n";
		
		for(int i = 0; i < performances.size(); i++)
		{
			out += performances.get(i).getRunner() + "\t";
			
			for(int j = 0; j < performances.get(i).getTimes().size(); j++)
			{
				out += performances.get(i).getPlaces().get(j) + "\t" + performances.get(i).getTimes().get(j) + "\t";
			}
			
			out += performances.get(i).getTeamPlace() + "\n";
		}
		
		return out;
	}

	public String getName()
	{
		return name;
	}

	public Date getDate()
	{
		return date;
	}

	public String getConditions()
	{
		return conditions;
	}

	public void setConditions(String conditions)
	{
		this.conditions = conditions;
	}

	public String getComments()
	{
		return comments;
	}

	public void setComments(String comments)
	{
		this.comments = comments;
	}

	public List<Run> getPerformances()
	{
		return performances;
	}
	
	public void setPerformances(List<Run> performances)
	{
		this.performances = performances;
	}
	
	public void addPerformance(Run performance)
	{
		performances.add(performance);
	}
}
