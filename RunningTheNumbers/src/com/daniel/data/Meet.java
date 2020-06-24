package com.daniel.data;

import java.util.ArrayList;
import java.util.List;

public class Meet extends TimeTrial
{
	private List<Scores> results;

	public Meet(String name, Date date, String conditions, String comments, List<Scores> results)
	{
		super(name, date, conditions, comments);
		
		this.results = results;
	}
	
	public List<Scores> getResults()
	{
		return results;
	}
}