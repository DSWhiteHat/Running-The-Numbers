package com.daniel.data;

import java.util.ArrayList;
import java.util.List;

public class Team
{
	String name;
	List<Meet> meets;
	List<Runner> runners;
	
	public Team(String name)
	{
		this.name = name;
		meets = new ArrayList<Meet>();
		runners = new ArrayList<Runner>();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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
