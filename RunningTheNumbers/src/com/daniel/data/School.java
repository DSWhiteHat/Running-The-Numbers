package com.daniel.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class School
{
	private String name;
	private HashMap<String, List<Team>> teams;
	private static HashMap<String, Integer> firstYears;
	
	public School(String name)
	{
		this.setName(name);
		
		teams = new HashMap<String, List<Team>>();
		teams.put("Boys", new ArrayList<Team>());
		teams.put("Girls", new ArrayList<Team>());
		
		firstYears = new HashMap<String, Integer>();
		firstYears.put("Boys", Integer.MAX_VALUE);
		firstYears.put("Girls", Integer.MAX_VALUE);
	}

	public String getName()
	{ return name; }

	public void setName(String name)
	{ this.name = name; }
	
	//Better to pass boolean male vs. String gender?
	public Team getTeam(String gender, int year)
	{
		return teams.get(gender).get(year - firstYears.get(gender));
	}

	public void addTeam(String gender, int year)
	{
		List<Team> temp = teams.get(gender);

		if (year < firstYears.get(gender))
		{
		    firstYears.put(gender, year);
		}
		
		int index = year - firstYears.get(gender);
		while (index >= temp.size()) {
		    temp.add(null);
		}

		if(temp.get(index) == null)
		{
		    temp.set(index, new Team(this, gender, year));
		}
		else
		{
		    temp.add(index, new Team(this, gender, year));
		}
	}

	public int getFirstYear(String gender)
	{
		return firstYears.get(gender);
	}
}
