package com.daniel.data;

import java.util.List;

public class Scores
{
	private List<String> teamNames;
	private List<Integer> scores;
	
	public Scores(List<String> teamNames, List<Integer> scores)
	{
		this.teamNames = teamNames;
		this.scores = scores;
	}
	
	public String toString()
	{
		String out = teamNames.get(0) + " (" + scores.get(0) + ")";
		for(int i = 1; i < teamNames.size(); i++)
		{
			out += " - " + teamNames.get(i) + " (" + scores.get(i) + ")";
		}
		return out;
	}
	
	public List<String> getTeamNames()
	{
		return teamNames;
	}
	
	public List<Integer> getScores()
	{
		return scores;
	}
}
