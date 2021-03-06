package com.daniel.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.daniel.data.Date;
import com.daniel.data.MeetSheet;
import com.daniel.data.Run;
import com.daniel.data.Runner;
import com.daniel.data.School;
import com.daniel.data.Scores;
import com.daniel.data.Team;
import com.daniel.data.Time;

import processing.core.PApplet;

public class Main
{
	/*
	 * public static List<Team> teams = new ArrayList<Team>(); public static List<Meet> meets = new ArrayList<Meet>();
	 */

	public static HashMap<String, School> schools = new HashMap<String, School>();

	public static void main(String[] args) throws IOException
	{
		PApplet.main("com.daniel.main.RunningTheNumbers");

		// scrubNew(new File("Data\\Boys\\2011"));
		/*
		String schoolName = "Cedar Crest High School";
		schools.put(schoolName, new School(schoolName));
		schools.get(schoolName).addTeam("Boys", 2011);
		System.out.println(load("Solanco", schoolName, "Boys", 2011));
		*/
		
		/*
		 * File meets = new File("Data/meets.csv"); scrub(meets); //System.out.println(query(performances, meets,
		 * "McCaskey & Annville-Cleona @ Lancaster Catholic (Boys)", "9/7/2010")); System.out.println(query(performances, meets,
		 * "1600 Time Trial (Boys)", "2010"));
		 */
		
		/*
		scrubNew(new File("Data/Cedar Crest High School/Girls/2011"));
		schools.put("Cedar Crest High School", loadAll(new School("Cedar Crest High School")));
		
		List<MeetSheet> meets = schools.get("Cedar Crest High School").getTeam("Boys", 2011).getMeetSheets();
		for (MeetSheet m : meets)
		{
			System.out.println("\n\n" + m);
		}
		*/
	}

	// Detects .csv files in the specified directory and scrubs them, converting them into .txt files.
	public static void scrubNew(File directory) throws IOException
	{
		System.out.println("Checking for new files to scrub...");
		File[] files = directory.listFiles();

		for (File f : files)
		{
			if (f.getName().contains(".csv"))
			{
				scrub(f);
			}
		}
	}

	// Cleans input CSV files and creates a text file of the same name and in the same location, but with the scrubbed data.
	public static void scrub(File csv) throws IOException
	{
		System.out.println("Scrubbing " + csv.getName() + "...");

		BufferedReader reader = new BufferedReader(new FileReader(csv));
		List<String> lines = new ArrayList<String>();

		// Meet Title.
		lines.add(removeTrailingCommas(reader.readLine()));

		// Date.
		lines.add(removeTrailingCommas(reader.readLine()));

		// Conditions.
		String line = reader.readLine();
		if (line.contains("Conditions:,"))
		{
			line = removeTrailingCommas(line.substring(12));
			if (line.charAt(0) == '"')
			{
				line = line.substring(1, line.length() - 1);
			}
			lines.add(line);
		}
		else
		{
			lines.add("");
		}

		// Mandatory white space line.
		reader.readLine();

		// Data Table
		line = reader.readLine();
		String[] split = separate(line);

		// Learning the columns that matter.
		List<Integer> goodIndices = new ArrayList<Integer>();
		for (int i = 0; i < split.length; i++)
		{
			if (split[i].equals("Mile 1") || split[i].equals("Place") || split[i].equals("Mile 2") || split[i].equals("5k") || split[i].equals("Fin. Place") || split[i].equals("Comments"))
			{
				goodIndices.add(i);
			}
		}

		// Storing those columns.
		while (line.charAt(0) != ',')
		{
			split = separate(line);

			line = split[0];
			for (int i = 0; i < goodIndices.size(); i++)
			{
				line += "," + split[goodIndices.get(i)];
			}
			lines.add(line);

			line = reader.readLine();
		}

		// Mandatory white space line in both CSV and text file to signify end of data table.
		line = reader.readLine();
		lines.add("");

		// Team scores, spaces removed.
		String scores = "";
		split = separate(line.substring(13));

		for (int i = 0; i < split.length; i++)
		{
			if (!split[i].isEmpty())
			{
				scores += removeSpace(split[i]) + ",";
			}
		}

		if (!scores.isEmpty())
		{
			scores = scores.substring(0, scores.length() - 1);
		}

		lines.add(scores);

		// Mandatory white space and the "#1-#5 Spread"" and "Coach's Comments:" lines.
		split = separate(reader.readLine());
		if (split.length >= 3)
		{
			lines.add(split[2]);
		}
		else
		{
			lines.add("");
		}

		reader.readLine();
		reader.readLine();

		String comments = "";

		// Comments could be longer than one line of the file.
		line = reader.readLine();
		while (line != null)
		{
			comments += line + "\n";
			line = reader.readLine();
		}

		// Removes extra \n and trailing commas.
		comments = removeTrailingCommas(comments.substring(0, comments.length() - 2));

		// Removing quotes at the beginning and end the CSV added.
		if (comments.charAt(0) == '"' && comments.charAt(comments.length() - 1) == '"')
		{
			comments = comments.substring(1, comments.length() - 1);
		}

		// Removing double quotes, which the file wizardy added at some point.
		comments = comments.replaceAll("\"\"", "\"");

		lines.add(comments);

		reader.close();

		// Creating a new text file of the same name and writing the stored lines to it.
		String csvName = csv.getAbsolutePath();
		File text = new File(csvName.substring(0, csvName.length() - 4) + ".txt");
		text.createNewFile();

		BufferedWriter writer = new BufferedWriter(new FileWriter(text));

		for (String l : lines)
		{
			writer.write(l + "\n");
		}

		writer.close();
	}
	
	// Loads all MeetSheets from the specified school.
	public static School loadAll(School school) throws IOException
	{
		System.out.println("Loading all data for " + school.getName() + "...");
		File[] genders = new File("Data/" + school.getName()).listFiles();
		
		for (File g : genders)
		{
			String gender = g.getName();
			File[] years = g.listFiles();
			for (File y : years)
			{
				int year = Integer.parseInt(y.getName());
				Team team = new Team(school, gender, year);
				File[] meets = y.listFiles();
				for (File meet : meets)
				{
					if (meet.getName().contains(".txt"))
					{
						System.out.println("Loading meet: " + meet.getName());
						load(team, meet.getName(), school.getName(), gender, year);
					}
				}
				school.addTeam(team, gender, year);
			}
		}
		
		return school;
	}

	// Returns the MeetSheet specified by the query.
	public static void load(Team team, String query, String school, String gender, int year) throws IOException
	{
		// Navigate file system to correct folder.
		File folder = new File("Data/" + school + "/" + gender + "/" + year);
		File[] meets = folder.listFiles();
		int index = -1;

		// Search for specified meet in specified folder.
		for (int i = 0; i < meets.length; i++)
		{
			if (meets[i].getName().toLowerCase().contains(query.toLowerCase()) && meets[i].getName().contains(".txt"))
			{
				index = i;
				break;
			}
		}

		if (index == -1)
		{
			System.out.println("Meet Not Found");
		}
		else
		{
			// Storing MeetSheet information from file.
			BufferedReader reader = new BufferedReader(new FileReader(meets[index]));

			String name = reader.readLine();
			Date date = new Date(reader.readLine());
			String conditions = reader.readLine();

			List<String> runs = new ArrayList<String>();
			String line = reader.readLine();

			while (line != null && !line.isEmpty())
			{
				runs.add(line);
				line = reader.readLine();
			}

			String results = reader.readLine();
			String spreadComments = reader.readLine();

			String comments = reader.readLine();
			line = reader.readLine();
			while (line != null)
			{
				comments += "\n" + line;
				line = reader.readLine();
			}
			reader.close();

			// Declaring object with stored data.
			MeetSheet meet = new MeetSheet(name, date, conditions, spreadComments, comments);

			// Adding team scores.
			meet.addResults(results);

			// Adding individual Runs.
			meet.addPerformances(team, runs, school, gender, year);
			
			team.addMeet(meet);
		}
	}

	/*
	 * public static void scrub(File file) throws IOException { BufferedReader reader = new BufferedReader(new FileReader(file));
	 * List<String> lines = new ArrayList<String>(); boolean quotes = false; String line = reader.readLine(); while (line != null) {
	 * //Removing header row to leave only relevant statistics in the file. if (!(line.contains("Name") && line.contains("Date"))) {
	 * //Removing leading spaces. while (line.charAt(0) == ' ') { line = line.substring(1); } for (int i = 1; i < line.length(); i++)
	 * { //Leaving sections in quotes untouched. if (line.charAt(i) == '"') { quotes = !quotes; } //Removing extra spaces next to
	 * commas or other spaces. if (!quotes && line.charAt(i) == ' ' && (line.charAt(i + 1) == ',' || line.charAt(i - 1) == ',' ||
	 * line.charAt(i + 1) == ' ')) { line = line.substring(0, i) + line.substring(i + 1); } //Removing extra spaces next to commas or
	 * other spaces. if (!quotes && line.charAt(i) == ':' && (line.charAt(i + 3) == ':')) { line = line.substring(0, i + 3) +
	 * line.substring(i + 6); } } lines.add(line); } line = reader.readLine(); } reader.close(); BufferedWriter writer = new
	 * BufferedWriter(new FileWriter(file)); //Putting the lines back in the file (except the header row). for (String l : lines) {
	 * writer.write(l + "\n"); } writer.close(); }
	 */

	// Returns the meet specified.
	/*
	 * public static Meet query(File performances, File meets, String name, String date) throws IOException { String search =
	 * name.toLowerCase(); BufferedReader reader = new BufferedReader(new FileReader(meets)); //Finding line with meet info from the
	 * "Meets" file. String line = reader.readLine(); while (line != null && !(line.toLowerCase().contains(search) &&
	 * line.contains(date))) { line = reader.readLine(); } //If no meet matched search criteria. if (line == null) {
	 * System.out.println("Search Failed."); reader.close(); return null; } //Removing unnecessary commas at the end of the line,
	 * places for extra score reports that were not used in this meet. while (line.charAt(line.length() - 1) == ',') { line =
	 * line.substring(0, line.length() - 1); } String[] split = separate(line); List<Scores> results = new ArrayList<Scores>();
	 * //Separating the team names and scores from the end of the line. for (int i = 4; i < split.length; i++) { List<String>
	 * teamNames = new ArrayList<String>(); List<Integer> scores = new ArrayList<Integer>(); String[] temp = split[i].split(" - ");
	 * for (int j = 0; j < temp.length; j++) { teamNames.add(temp[j].substring(0, temp[j].lastIndexOf(' ')));
	 * scores.add(Integer.parseInt(temp[j].substring(temp[j].lastIndexOf(' ') + 1))); } results.add(new Scores(teamNames, scores)); }
	 * //Creating Meet object. Meet output = new Meet(name, new Date(split[1]), split[2], split[3].replaceAll("\"", ""), results);
	 * reader.close(); reader = new BufferedReader(new FileReader(performances)); //Searching for the lines containing the
	 * performances run at this meet. line = reader.readLine(); while (line != null) { if (line.toLowerCase().contains(search) &&
	 * line.contains(date)) { String[] performance = separate(line); List<Time> times = new ArrayList<Time>(); List<Integer> places =
	 * new ArrayList<Integer>(); //Finding all times listed on the line, both splits and final, whatever is provided. for (int i = 4;
	 * i <= 8; i += 2) { if (performance[i] != null && !performance[i].equals("")) { times.add(new Time(performance[i])); } }
	 * //Finding all places listed on the line, both splits and final, whatever is provided. for (int i = 3; i <= 7; i += 2) { if
	 * (performance[i] != null && !performance[i].equals("")) { //If someone missed this person's place.
	 * if(performance[i].equals("?")) { places.add(-1); } else { places.add(Integer.parseInt(performance[i])); } } } //Adding the
	 * place on the team. Codes: -1 -> unknown, -2 -> Did Not Finish, -3 -> Did Not Race. int temp = 0; if(performance[9].equals("?"))
	 * { temp = -1; } else if(performance[9].equals("DNF")) { temp = -2; } else if(performance[9].equals("DNR")) { temp = -3; } else {
	 * temp = Integer.parseInt(performance[9]); } output.addPerformance(new Run(performance[0], times, output, temp, places)); } line
	 * = reader.readLine(); } reader.close(); return output; }
	 */

	// Splits a CSV line around commas, but ignoring sections in quotes, and removes leading and trailing spaces.
	public static String[] separate(String csv)
	{
		List<String> list = new ArrayList<String>();
		boolean quote = false;
		int comma = -1;

		for (int i = 0; i < csv.length() + 1; i++)
		{
			if (i < csv.length() && csv.charAt(i) == '"')
			{
				quote = !quote;
			}

			if (i == csv.length() || !quote && csv.charAt(i) == ',')
			{
				list.add(removeSpace(csv.substring(comma + 1, i)));
				comma = i;
			}
		}

		String[] output = new String[list.size()];
		output = list.toArray(output);

		return output;
	}

	public static String removeSpace(String string)
	{
		while (string.length() > 0 && string.charAt(0) == ' ')
		{
			string = string.substring(1);
		}

		while (string.length() > 0 && string.charAt(string.length() - 1) == ' ')
		{
			string = string.substring(0, string.length() - 1);
		}
		return string;
	}

	public static String removeTrailingCommas(String string)
	{
		while (string.charAt(string.length() - 1) == ',')
		{
			string = string.substring(0, string.length() - 1);
		}

		return string;
	}
}
