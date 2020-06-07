package com.daniel.display;

import com.daniel.data.Time;

import processing.core.PApplet;

public class Graph extends DrawnText
{
	// The upper and lower year values displayed on the chart.
	public static int startYear = 2014;
	public static int endYear = 2019;

	// The upper and lower time values displayed on the chart.
	public static float fastTime = Time.parseTime("15:00");
	public static float slowTime = Time.parseTime("19:00");

	// The amount of time between each marked interval on the chart.
	public static float timeIncrement = Time.parseTime("00:30");

	private float w;
	private float h;

	public Graph(float x, float y, PApplet p, float w, float h, int c, float textSize, int textColor)
	{
		super(x, y, p, c, textSize, textColor);
		this.w = w;
		this.h = h;
	}

	public void update()
	{

	}

	// Draws the chart on which the running data is displayed.
	public void display()
	{
		getP().stroke(getC());
		getP().textAlign(getP().CENTER, getP().TOP);
		getP().textSize(getTextSize());

		// Vertical lines on the chart, each corresponding to a year value displayed on
		// the bottom.
		float offset = w / (endYear - startYear + 2);
		for (int i = 0; i <= endYear - startYear; i++)
		{
			getP().line(getX() + offset * (i + 1), getY(), getX() + offset * (i + 1), h + getY());
			getP().text(startYear + i, getX() + offset * (i + 1), h + getY());
		}

		// Horizontal lines on the chart, each corresponding to a time value displayed
		// on the lefthand side.
		offset = h * timeIncrement / (slowTime - fastTime);
		for (int i = 0; i <= (slowTime - fastTime) / timeIncrement; i++)
		{
			GraphicsHelper.dottedLine(getP(), getX(), getY() + offset * i, w + getX(), getY() + offset * i);

			getP().textAlign(getP().RIGHT);
			getP().text(Time.constructTime(slowTime - timeIncrement * i), getX() - 10, (float) (getY() + offset * i + getTextSize() * .5));
		}

		// Vertical lines on the two sides of the chart.
		getP().line(getX(), getY(), getX(), h + getY());
		getP().line(w + getX(), getY(), w + getX(), h + getY());

		// Horizontal lines at the top and bottom of the chart.
		getP().line(getX(), getY(), w + getX(), getY());
		getP().line(getX(), h + getY(), w + getX(), h + getY());
	}
}
