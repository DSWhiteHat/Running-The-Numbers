package com.daniel.data;

import java.util.List;

public class Scores
{
	private List<Team> teams;
	private List<Integer> scores;
	
	public Scores(List<Team> teams, List<Integer> scores)
	{
		this.teams = teams;
		this.scores = scores;
	}
	
	public String toString()
	{
		String out = teams.get(0) + " (" + scores.get(0) + ")";
		for(int i = 1; i < teams.size(); i++)
		{
			out += " - " + teams.get(i) + " (" + scores.get(i) + ")";
		}
		return out;
	}
	
	public List<Team> getTeams()
	{
		return teams;
	}
	
	public List<Integer> getScores()
	{
		return scores;
	}
}
