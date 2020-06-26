package com.daniel.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.daniel.data.Date;
import com.daniel.data.Meet;
import com.daniel.data.Run;
import com.daniel.data.Scores;
import com.daniel.data.Time;

import processing.core.PApplet;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		// PApplet.main("com.daniel.main.RunningTheNumbers");
		
		File performances = new File("Data/performances.csv");
		scrub(performances);
		
		/*
		File meets = new File("Data/meets.csv");
		scrub(meets);

		//System.out.println(query(performances, meets, "McCaskey & Annville-Cleona @ Lancaster Catholic (Boys)", "9/7/2010"));
		System.out.println(query(performances, meets, "1600 Time Trial (Boys)", "2010"));
		*/
	}

	//Cleans up the csv lines to prepare them for analysis.
	public static void scrub(File file) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		List<String> lines = new ArrayList<String>();
		boolean quotes = false;

		String line = reader.readLine();
		while (line != null)
		{
			//Removing header row to leave only relevant statistics in the file.
			if (!(line.contains("Name") && line.contains("Date")))
			{
				//Removing leading spaces.
				while (line.charAt(0) == ' ')
				{
					line = line.substring(1);
				}

				for (int i = 1; i < line.length(); i++)
				{
					//Leaving sections in quotes untouched.
					if (line.charAt(i) == '"')
					{
						quotes = !quotes;
					}

					//Removing extra spaces next to commas or other spaces.
					if (!quotes && line.charAt(i) == ' ' && (line.charAt(i + 1) == ',' || line.charAt(i - 1) == ',' || line.charAt(i + 1) == ' '))
					{
						line = line.substring(0, i) + line.substring(i + 1);
					}
					
					//Removing extra spaces next to commas or other spaces.
					if (!quotes && line.charAt(i) == ':' && (line.charAt(i + 3) == ':'))
					{
						line = line.substring(0, i + 3) + line.substring(i + 6);
					}
				}

				lines.add(line);
			}

			line = reader.readLine();
		}

		reader.close();

		BufferedWriter writer = new BufferedWriter(new FileWriter(file));

		//Putting the lines back in the file (except the header row).
		for (String l : lines)
		{
			writer.write(l + "\n");
		}

		writer.close();
	}

	//Returns the meet specified.
	public static Meet query(File performances, File meets, String name, String date) throws IOException
	{
		String search = name.toLowerCase();

		BufferedReader reader = new BufferedReader(new FileReader(meets));

		//Finding line with meet info from the "Meets" file.
		String line = reader.readLine();
		while (line != null && !(line.toLowerCase().contains(search) && line.contains(date)))
		{
			line = reader.readLine();
		}

		//If no meet matched search criteria.
		if (line == null)
		{
			System.out.println("Search Failed.");
			reader.close();
			return null;
		}
		
		//Removing unnecessary commas at the end of the line, places for extra score reports that were not used in this meet.
		while (line.charAt(line.length() - 1) == ',')
		{
			line = line.substring(0, line.length() - 1);
		}

		String[] split = separate(line);

		List<Scores> results = new ArrayList<Scores>();

		//Separating the team names and scores from the end of the line.
		for (int i = 4; i < split.length; i++)
		{
			List<String> teamNames = new ArrayList<String>();
			List<Integer> scores = new ArrayList<Integer>();

			String[] temp = split[i].split(" - ");

			for (int j = 0; j < temp.length; j++)
			{
				teamNames.add(temp[j].substring(0, temp[j].lastIndexOf(' ')));
				scores.add(Integer.parseInt(temp[j].substring(temp[j].lastIndexOf(' ') + 1)));
			}

			results.add(new Scores(teamNames, scores));
		}

		//Creating Meet object.
		Meet output = new Meet(name, new Date(split[1]), split[2], split[3].replaceAll("\"", ""), results);

		reader.close();
		reader = new BufferedReader(new FileReader(performances));

		//Searching for the lines containing the performances run at this meet.
		line = reader.readLine();
		while (line != null)
		{
			if (line.toLowerCase().contains(search) && line.contains(date))
			{
				String[] performance = separate(line);

				List<Time> times = new ArrayList<Time>();
				List<Integer> places = new ArrayList<Integer>();

				//Finding all times listed on the line, both splits and final, whatever is provided.
				for (int i = 4; i <= 8; i += 2)
				{
					if (performance[i] != null && !performance[i].equals(""))
					{
						times.add(new Time(performance[i]));
					}
				}

				//Finding all places listed on the line, both splits and final, whatever is provided.
				for (int i = 3; i <= 7; i += 2)
				{
					if (performance[i] != null && !performance[i].equals(""))
					{
						//If someone missed this person's place.
						if(performance[i].equals("?"))
						{
							places.add(-1);
						}
						else
						{
							places.add(Integer.parseInt(performance[i]));
						}
					}
				}
				
				//Adding the place on the team. Codes: -1 -> unknown, -2 -> Did Not Finish, -3 -> Did Not Race.
				int temp = 0;
				if(performance[9].equals("?"))
				{
					temp = -1;
				}
				else if(performance[9].equals("DNF"))
				{
					temp = -2;
				}
				else if(performance[9].equals("DNR"))
				{
					temp = -3;
				}
				else
				{
					temp = Integer.parseInt(performance[9]);
				}
				output.addPerformance(new Run(performance[0], times, output, temp, places));
			}
			line = reader.readLine();
		}

		reader.close();
		return output;
	}

	//Spliting a csv line around commas, but ignoring sections in quotes.
	public static String[] separate(String csv)
	{
		List<String> list = new ArrayList<String>();
		boolean quote = false;
		int comma = -1;

		for (int i = 0; i < csv.length(); i++)
		{
			if (csv.charAt(i) == '"')
			{
				quote = !quote;
			}

			if (!quote && csv.charAt(i) == ',')
			{
				list.add(csv.substring(comma + 1, i));
				comma = i;
			}
		}
		list.add(csv.substring(comma + 1));

		String[] output = new String[list.size()];
		output = list.toArray(output);

		return output;
	}
}
