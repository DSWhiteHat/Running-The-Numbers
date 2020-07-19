package com.daniel.data;

import java.util.ArrayList;
import java.util.List;

public class Meet
{
	private String name;
	private Date date;
	private String conditions;
	private List<Run> performances;
	private List<Scores> results;
	private String spreadComments;
	private String comments;

	public Meet(String name, Date date, String conditions, List<Run> performances, List<Scores> results, String spreadComments, String comments)
	{
		this.name = name;
		this.date = date;
		this.conditions = conditions;
		this.performances = performances;
		this.results = results;
		this.spreadComments = spreadComments;
		this.comments = comments;
	}

	public Meet(String name, Date date, String conditions, String spreadComments, String comments)
	{
		this.name = name;
		this.date = date;
		this.conditions = conditions;
		this.spreadComments = spreadComments;
		this.comments = comments;

		performances = new ArrayList<Run>();
		results = new ArrayList<Scores>();
	}

	public boolean equals(Meet other)
	{
		return name.equals(other.getName()) && date.equals(other.getDate());
	}

	public String toString()
	{
		String out = name + ", " + date + "\n" + conditions + "\n" + comments + "\n";

		out += "Performances: \n";

		for (int i = 0; i < performances.size(); i++)
		{
			out += performances.get(i).getRunner() + "\t\t";

			for (int j = 0; j < performances.get(i).getTimes().length; j++)
			{
				out += performances.get(i).getPlaces()[j] + "\t" + performances.get(i).getTimes()[j] + "\t";
			}

			out += performances.get(i).getTeamPlace() + "\n";
		}

		if (results.size() != 0)
		{
			out += "Scores: \n";

			for (int i = 0; i < results.size(); i++)
			{
				out += results.get(i).toString() + "\n";
			}
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

	public List<Scores> getResults()
	{
		return results;
	}

	public void setResults(List<Scores> results)
	{
		this.results = results;
	}

	public String getSpreadComments()
	{
		return spreadComments;
	}

	public void setSpreadComments(String spreadComments)
	{
		this.spreadComments = spreadComments;
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