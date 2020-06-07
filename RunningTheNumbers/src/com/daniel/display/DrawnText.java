package com.daniel.display;

import processing.core.PApplet;

public abstract class DrawnText extends DrawnColor
{
	private float textSize;
	private int textColor;

	public DrawnText(float x, float y, PApplet p, int c, float textSize, int textColor)
	{
		super(x, y, p, c);

		this.textSize = textSize;
		this.textColor = textColor;
	}

	public float getTextSize()
	{
		return textSize;
	}

	public void setTextSize(float textSize)
	{
		this.textSize = textSize;
	}

	public int getTextColor()
	{
		return textColor;
	}

	public void setTextColor(int textColor)
	{
		this.textColor = textColor;
	}
}
