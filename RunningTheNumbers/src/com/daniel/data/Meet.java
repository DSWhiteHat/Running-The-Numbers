package com.daniel.data;

import java.util.ArrayList;

public class Meet extends TimeTrial
{
	private ArrayList<Integer> teamScores;

	public Meet(String name, Date date)
	{
		super(name, date);
		
		teamScores = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getTeamScores()
	{
		return teamScores;
	}
}