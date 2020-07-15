package com.daniel.data;

import java.util.ArrayList;
import java.util.List;

public class Team
{
	String name;
	List<Runner> members;

	public Team(String name, List<Runner> members)
	{
		this.name = name;
		this.members = members;
	}
	
	public Team(String name)
	{
		this.name = name;
		members = new ArrayList<Runner>();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Runner> getMembers()
	{
		return members;
	}

	public void setMembers(List<Runner> members)
	{
		this.members = members;
	}
}
