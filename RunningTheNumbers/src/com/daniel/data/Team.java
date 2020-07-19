package com.daniel.data;

import java.util.ArrayList;
import java.util.List;

public class Team
{
	String name;
	List<Runner> runners;

	public Team(String name, List<Runner> runners)
	{
		this.name = name;
		this.runners = runners;
	}
	
	public Team(String name)
	{
		this.name = name;
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

	public List<Runner> getRunners()
	{
		return runners;
	}

	public void setRunners(List<Runner> runners)
	{
		this.runners = runners;
	}
}
