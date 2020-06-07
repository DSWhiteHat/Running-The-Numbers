package com.daniel.display;

import processing.core.PApplet;

public abstract class DrawnColor extends Drawn
{
	private int c;

	public DrawnColor(float x, float y, PApplet p, int c)
	{
		super(x, y, p);
		this.c = c;
	}

	public int getC()
	{
		return c;
	}

	public void setC(int c)
	{
		this.c = c;
	}
}
