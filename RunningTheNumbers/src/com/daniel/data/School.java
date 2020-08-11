package com.daniel.data;

import java.util.ArrayList;
import java.util.List;

public class School
{
	private String name;
	private List<Team> boys;
	private List<Team> girls;

	public School(String name)
	{
		this.setName(name);
		setBoys(new ArrayList<Team>());
		setGirls(new ArrayList<Team>());
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Team> getBoys()
	{
		return boys;
	}

	public void setBoys(List<Team> boys)
	{
		this.boys = boys;
	}

	public List<Team> getGirls()
	{
		return girls;
	}

	public void setGirls(List<Team> girls)
	{
		this.girls = girls;
	}
}
