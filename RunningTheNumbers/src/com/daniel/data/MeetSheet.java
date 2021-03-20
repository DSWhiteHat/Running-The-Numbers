package com.daniel.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.daniel.main.Main;

public class MeetSheet
{
	private String name;
	private Date date;
	private String conditions;
	private List<Run> performances;
	private List<Scores> results;
	private String spreadComments;
	private String comments;

	public MeetSheet(String name, Date date, String conditions, List<Run> performances, List<Scores> results, String spreadComments, String comments)
	{
		this.name = name;
		this.date = date;
		this.conditions = conditions;
		this.performances = performances;
		this.results = results;
		this.spreadComments = spreadComments;
		this.comments = comments;
	}

	public MeetSheet(String name, Date date, String conditions, String spreadComments, String comments)
	{
		this.name = name;
		this.date = date;
		this.conditions = conditions;
		this.spreadComments = spreadComments;
		this.comments = comments;

		performances = new ArrayList<Run>();
		results = new ArrayList<Scores>();
	}

	public boolean equals(MeetSheet other)
	{
		return name.equals(other.getName()) && date.equals(other.getDate());
	}

	public String toString()
	{
		String out = name + ", " + date + "\n" + conditions + "\n";

		out += "Performances: \n";
		out += "Runner:\t\tMile 1:\tPlace:\tMile 2:\tPlace:\t5k:\tFin.Place\tTeam Place:\tComments:\n";

		for (int i = 0; i < performances.size(); i++)
		{
			out += performances.get(i).toString();
		}

		if (results.size() != 0)
		{
			out += "\nScores: \n";

			for (int i = 0; i < results.size(); i++)
			{
				out += results.get(i).toString() + "\n";
			}
		}
		
		out += "\nSpread Comments:\n" + spreadComments;
		out += "\nComments:\n" + comments;

		return out;
	}

	public String getName()
	{ return name; }

	public Date getDate()
	{ return date; }

	public String getConditions()
	{ return conditions; }

	public void setConditions(String conditions)
	{ this.conditions = conditions; }

	public List<Run> getPerformances()
	{ return performances; }

	public void setPerformances(List<Run> performances)
	{ this.performances = performances; }

	public void addPerformances(Team team, List<String> performances, String school, String gender, int year)
	{
		String[] key = Main.separate(performances.remove(0));
		for (int i = 0; i < performances.size(); i++)
		{
			Time[] times = new Time[3];
			int[] places = new int[3];
			String individualComments = "";

			int currentMile = 3;
			String[] split = Main.separate(performances.get(i));
			String name = split[0];
			for (int j = 1; j < key.length; j++)
			{
				if (key[j].equals("Mile 1"))
				{
					times[0] = new Time(split[j]);
					currentMile = 1;
				}
				else if (key[j].equals("Mile 2"))
				{
					times[1] = new Time(split[j]);
					currentMile = 2;
				}
				else if (key[j].equals("5k"))
				{
					times[2] = new Time(split[j]);
					currentMile = 3;
				}
				else if (key[j].equals("Place"))
				{
					if (split[j].equals("DNF"))
					{
						places[currentMile - 1] = Integer.MAX_VALUE;
					}
					else if(split[j].isBlank())
					{
						places[currentMile - 1] = -1;
					}
					else
					{
						places[currentMile - 1] = Integer.parseInt(split[j]);
					}
				}
				else if (key[j].equals("Fin. Place"))
				{
					if (split[j].equals("DNR"))
					{
						places[currentMile - 1] = Integer.MAX_VALUE;
					}
					else if(split[j].equals("DNF"))
					{
						places[currentMile - 1] = Integer.MAX_VALUE - 1;
					}
					else if(split[j].contains("?"))
					{
						places[currentMile - 1] = Integer.MAX_VALUE - 2;
					}
					else
					{
						places[places.length - 1] = Integer.parseInt(split[j]);
					}
				}
				else if (key[j].equals("Comments"))
				{
					individualComments = split[j];
				}
			}

			// Temporarily making meet year graduation year.
			Runner runner = new Runner(name, year);
			boolean newRunner = true;
			for (int j = 0; j < team.getRunners().size(); j++)
			{
				if (team.getRunners().get(j).getName().equals(name))
				{
					runner = team.getRunners().get(j);
					newRunner = false;
				}
			}
			if (newRunner)
			{
				team.addRunner(runner);
			}

			Run performance = new Run(this, runner, times, i + 1, places, individualComments);
			this.performances.add(performance);
			runner.addPerformance(performance);
		}
	}

	public List<Scores> getResults()
	{ return results; }

	public void setResults(List<Scores> results)
	{ this.results = results; }

	public void addResults(String results) throws IOException
	{
		// Getting school name abbreviations likely used in the data.
		BufferedReader reader = new BufferedReader(new FileReader(new File("Data/School Abreviations.txt")));
		List<String> lines = new ArrayList<String>();

		String line = reader.readLine();
		while (line != null)
		{
			lines.add(line);
			line = reader.readLine();
		}

		// Deciphering the team scores from the 'scores' line of the file.
		if (!results.isBlank())
		{
			String[] split = Main.separate(results);
			
			for (int i = 0; i < split.length; i++)
			{
				List<String> schoolNames = new ArrayList<String>();
				List<Integer> scores = new ArrayList<Integer>();
				String[] spliter = split[i].split("; ");
	
				for (int j = 0; j < spliter.length; j++)
				{
					String[] splitest = spliter[j].split("-");
	
					for (int k = 0; k < lines.size(); k++)
					{
						// Finding which school the school abbreviations used in the meet sheet correspond to.
						if (lines.get(k).contains(" " + splitest[0] + ","))
						{
							String schoolName = lines.get(k).substring(0, lines.get(k).indexOf(':'));
							schoolNames.add(schoolName);
						}
					}
	
					scores.add(Integer.parseInt(splitest[1]));
				}
				
				this.results.add(new Scores(schoolNames, scores));
			}
		}
	}

	public String getSpreadComments()
	{ return spreadComments; }

	public void setSpreadComments(String spreadComments)
	{ this.spreadComments = spreadComments; }

	public String getComments()
	{ return comments; }

	public void setComments(String comments)
	{ this.comments = comments; }
}