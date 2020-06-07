package com.daniel.display;

import processing.core.PApplet;

public abstract class Drawn
{
	private float x;
	private float y;
	
	private PApplet p;

	public Drawn(float x, float y, PApplet p)
	{
		this.x = x;
		this.y = y;
		
		this.p = p;
	}

	public abstract void update();

	public abstract void display();

	public float getX()
	{
		return x;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public float getY()
	{
		return y;
	}

	public void setY(float y)
	{
		this.y = y;
	}
	
	public PApplet getP()
	{
		return p;
	}

	public void setP(PApplet p)
	{
		this.p = p;
	}
}
