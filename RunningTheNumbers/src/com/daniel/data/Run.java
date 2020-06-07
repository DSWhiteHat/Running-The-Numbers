package com.daniel.data;

public class Run implements Comparable<Run>
{
	private Meet meet;
	private Runner runner;
	private Time time;

	public Run(Runner runner, Time time, Meet meet)
	{
		this.meet = meet;
		this.runner = runner;
		this.time = time;
	}

	public int compareTo(Run other)
	{
		return time.compareTo(other.getTime());
	}

	public Meet getMeet()
	{
		return meet;
	}

	public Runner getRunner()
	{
		return runner;
	}

	public Time getTime()
	{
		return time;
	}
}
