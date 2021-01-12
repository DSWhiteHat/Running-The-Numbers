//Currently only for use in MeetSheets, Scores are not linked to Team objects, only school names.

package com.daniel.data;

import java.util.List;

public class Scores
{
	private List<String> schools;
	private List<Integer> scores;
	
	public Scores(List<String> schools, List<Integer> scores)
	{
		this.schools = schools;
		this.scores = scores;
	}
	
	public String toString()
	{
		String out = schools.get(0) + " (" + scores.get(0) + ")";
		for(int i = 1; i < schools.size(); i++)
		{
			out += " - " + schools.get(i) + " (" + scores.get(i) + ")";
		}
		return out;
	}
	
	public List<String> getSchools()
	{
		return schools;
	}
	
	public List<Integer> getScores()
	{
		return scores;
	}
}
