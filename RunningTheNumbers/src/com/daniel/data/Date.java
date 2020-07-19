package com.daniel.data;

public class Date implements Comparable<Date>
{
	private static int[] monthToDays = { 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
	private int month;
	private int day;
	private int year;
	private float comparable;

	public Date(int month, int day, int year)
	{
		this.month = month;
		this.day = day;
		this.year = year;

		comparable = toFloat();
	}
	
	public Date(String date)
	{
		String[] split = date.split("/");
		
		month = Integer.parseInt(split[0]);
		day = Integer.parseInt(split[1]);
		year = Integer.parseInt(split[2]);
		
		comparable = toFloat();
	}
	
	public int compareTo(Date other)
	{
		if (comparable == other.getComparable())
		{
			return 0;
		}
		else if (comparable > other.getComparable())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	
	public boolean equals(Date other)
	{
		return comparable == other.getComparable();
	}

	public String toString()
	{
		return month + "/" + day + "/" + year;
	}

	public float toFloat()
	{
		comparable = year;

		float days = day + monthToDays[month - 2];

		comparable += (days / 365);

		return comparable;
	}

	public int getMonth()
	{
		return month;
	}

	public int getDay()
	{
		return day;
	}

	public int getYear()
	{
		return year;
	}

	public float getComparable()
	{
		return comparable;
	}
}
