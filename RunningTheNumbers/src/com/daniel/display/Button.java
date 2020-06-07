package com.daniel.display;

import processing.core.PApplet;

public class Button extends DrawnText
{
	// Button Curviness
	public static final float BUTTON_CURVE = 5;
	
	private float w;
	private float h;
	
	private String text;
	private Runnable onClick;

	public Button(float x, float y, PApplet p, float w, float h, int c, String text, float textSize, int textColor, Runnable onClick)
	{
		super(x, y, p, c, textSize, textColor);

		this.w = w;
		this.h = h;

		this.text = text;
		this.onClick = onClick;
	}

	public void update()
	{

	}

	public void display()
	{
		getP().fill(getC());
		getP().rect(getX(), getY(), w, h, BUTTON_CURVE);

		getP().fill(getTextColor());
		getP().textAlign(getP().CENTER, getP().CENTER);
		getP().textSize(getTextSize());
		getP().text(text, getX() + w / 2, getY() + h / 2);
	}

	public boolean clicked()
	{
		if (getP().mouseX > getX() && getP().mouseX < getX() + w && getP().mouseY > getY() && getP().mouseY < getY() + h)
		{
			onClick.run();
			return true;
		}
		else
		{
			return false;
		}
	}

	public float getWidth()
	{
		return w;
	}

	public void setWidth(float w)
	{
		this.w = w;
	}

	public float getHeight()
	{
		return h;
	}

	public void setHeight(float h)
	{
		this.h = h;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public Runnable getOnClick()
	{
		return onClick;
	}

	public void setOnClick(Runnable onClick)
	{
		this.onClick = onClick;
	}
}
