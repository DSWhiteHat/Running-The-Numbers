package com.daniel.data;

import java.util.ArrayList;
import java.util.List;

public class Team
{
	//Identifying
	private School school;
	private String gender;
	private int year;
	
	//Content
	private List<MeetSheet> meetSheets;
	private List<Runner> runners;
	
	public Team(School school, String gender, int year)
	{
		this.school = school;
		this.gender = gender;
		this.year = year;
		
		meetSheets = new ArrayList<MeetSheet>();
		runners = new ArrayList<Runner>();
	}
	
	/*Super sus.
	public Team(School school)
	{
		this.school = school;
		this.year = -1;
		this.boys = false;
		meets = new ArrayList<Meet>();
		runners = new ArrayList<Runner>();
	}
	*/

	public School getSchool()
	{
		return school;
	}

	public void setSchool(School school)
	{
		this.school = school;
	}

	public List<MeetSheet> getMeetSheets()
	{
		return meetSheets;
	}

	public void setMeetSheets(List<MeetSheet> meetSheets)
	{
		this.meetSheets = meetSheets;
	}
	
	public void addMeet(MeetSheet meetSheet)
	{
		meetSheets.add(meetSheet);
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
