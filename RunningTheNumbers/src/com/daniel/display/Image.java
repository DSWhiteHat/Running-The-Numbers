package com.daniel.display;

import processing.core.PApplet;
import processing.core.PImage;

public class Image extends Drawn
{
	private PImage image;
	private float xScale, yScale;
	
	public Image(float x, float y, PApplet p, PImage image, float xScale, float yScale)
	{
		super(x, y, p);
		
		this.image = image;
		this.xScale = xScale;
		this.yScale = yScale;
	}
	
	public void update()
	{
		if (xScale >= 0)
		{
			image.resize((int)(getP().width * xScale), image.height);
		}
		
		if (yScale >= 0)
		{
			image.resize(image.width, (int)(getP().height * yScale));
		}
	}
	
	public void display()
	{
		getP().image(image, getP().width * getX(), getP().height * getY());
	}
	
	public PImage getPImage()
	{
		return image;
	}
}
