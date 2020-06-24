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

import com.daniel.data.Run;
import com.daniel.data.Time;

import processing.core.PApplet;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		//PApplet.main("com.daniel.main.RunningTheNumbers");
		
		File data = new File("Data/individual.csv");
		scrub(data);
		store(data);
	}
	
	public static void scrub(File file) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		List<String> lines = new ArrayList<String>();
		
		String line = reader.readLine();
		while(line != null)
		{
			while(line.charAt(0) == ' ')
			{
				line = line.substring(1);
			}
			
			for(int i = 1; i < line.length(); i++)
			{
				if(line.charAt(i) == ' ' && (line.charAt(i + 1) == ',' || line.charAt(i - 1) == ','))
				{
					line = line.substring(0, i) + line.substring(i + 1);
				}
			}
			
			lines.add(line);
			line = reader.readLine();
		}
		
		reader.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		
		for(String l : lines)
		{
			writer.write(l + "\n");
		}
		
		writer.close();
	}
	
	public static void store(File file) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		List<Run> performances = new ArrayList<Run>();
		
		List<Time> times = new ArrayList<Time>();
		List<Integer> teamPlaces = new ArrayList<Integer>();
		List<Integer> places = new ArrayList<Integer>();
		
		String line = reader.readLine();
		while(line != null)
		{
			String[] split = line.split(",");
			System.out.println(Arrays.deepToString(split));
			line = reader.readLine();
		}
		
		reader.close();
	}
}
