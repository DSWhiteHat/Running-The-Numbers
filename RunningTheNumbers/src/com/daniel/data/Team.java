package com.daniel.data;

import java.util.ArrayList;
import java.util.List;

public class Team
{
	private School school;
	private int year;
	private boolean boys;
	private List<Meet> meets;
	private List<Runner> runners;
	
	public Team(School school, int year, boolean boys)
	{
		this.school = school;
		this.year = year;
		this.boys = boys;
		meets = new ArrayList<Meet>();
		runners = new ArrayList<Runner>();
	}

	public School getSchool()
	{
		return school;
	}

	public void setName(School school)
	{
		this.school = school;
	}

	public List<Meet> getMeets()
	{
		return meets;
	}

	public void setMeets(List<Meet> meets)
	{
		this.meets = meets;
	}
	
	public void addMeet(Meet meet)
	{
		meets.add(meet);
	}

	public List<Runner> getRunners()
	{
		return runners;
	}

	public void setRunners(List<Runner> runners)
	{
		this.runners = runners;
	}
	
	public void addRunner(Runner runner)
	{
		runners.add(runner);
	}
}
