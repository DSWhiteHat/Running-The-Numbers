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
	
	public List<String> getTeamNames()
	{
		return teamNames;
	}
	
	public List<Integer> getScores()
	{
		return scores;
	}
}
