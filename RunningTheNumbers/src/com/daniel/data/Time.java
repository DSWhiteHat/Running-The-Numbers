package com.daniel.data;

import java.util.ArrayList;

public class Time implements Comparable<Time>
{
	private String minuteSecond;
	private float minuteDecimal;
	
	public Time(String minuteSecond)
	{
		this.minuteSecond = minuteSecond;
		minuteDecimal = parseTime(minuteSecond);
	}

	public Time(float minuteDecimal)
	{
		this.minuteDecimal = minuteDecimal;
		minuteSecond = constructTime(minuteDecimal);
	}

	// Converts a decimal value of a time in minutes (17.016666666) to a time in
	// minutes:seconds (17:01).
	public static String constructTime(float formatted)
	{
		String time = "";

		int minutes = (int) formatted;
		time += minutes + ":";

		int seconds = (int) Math.round((formatted - minutes) * 60);

		if (seconds < 10)
		{
			time += "0";
		}

		time += seconds;

		return time;
	}

	// Converts a minutes:seconds time (17:01) to a decimal value in minutes
	// (17.016666666).
	public static float parseTime(String time)
	{
		float formatted = 0.0f;

		String minutes = time.split(":")[0];
		String seconds = time.split(":")[1];

		formatted += Float.parseFloat(minutes);
		formatted += Float.parseFloat(seconds) / 60;

		return formatted;
	}

	public static Time average(ArrayList<Run> performances)
	{
		float total = 0.0f;

		for (int i = 0; i < performances.size(); i++)
		{
			total += performances.get(i).getTime().getMinuteDecimal();
		}

		return new Time(total / performances.size());
	}

	public int compareTo(Time other)
	{
		Time temp = (Time) other;

		if (minuteDecimal == temp.getMinuteDecimal())
		{
			return 0;
		}
		else if (minuteDecimal > temp.getMinuteDecimal())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}

	public String getMinuteSecond()
	{
		return minuteSecond;
	}

	public float getMinuteDecimal()
	{
		return minuteDecimal;
	}
}
