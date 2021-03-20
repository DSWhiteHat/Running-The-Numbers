package com.daniel.display;

import com.daniel.main.RunningTheNumbers;

import processing.core.PApplet;

public class Page extends DrawnText
{
	private String title;
	private AllDrawn drawn;

	public Page(float x, float y, PApplet p, int c, float textSize, int textColor, String title, AllDrawn drawn)
	{
		super(x, y, p, c, textSize, textColor);
		
		this.title = title;
		this.drawn = drawn;
	}
	
	public void update()
	{
		drawn.update();
	}
	
	public void display()
	{
		getP().background(getC());
		drawn.display();
		
		getP().stroke(getTextColor());
		getP().textAlign(getP().CENTER, getP().TOP);
		getP().textSize(getTextSize());
		//getP().text(title, getX() + getP().width / 2, getY()); BORING TEXT TITLE
	}
	
	public AllDrawn getDrawn()
	{
		return drawn;
	}
	
	public void setDrawn(AllDrawn drawn)
	{
		this.drawn = drawn;
	}
	
	public void addDrawn(Drawn drawn)
	{
		this.drawn.addDrawn(drawn);
	}
}
