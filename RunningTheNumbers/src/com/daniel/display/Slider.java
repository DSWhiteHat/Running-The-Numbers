package com.daniel.display;

import processing.core.PApplet;

public class Slider extends Button
{
	public Slider(float x, float y, PApplet p, float w, float h, int c, String text, float textSize, int textColor, Runnable onClick)
	{
		super(x, y, p, w, h, c, text, textSize, textColor, onClick);
	}

	public void display()
	{
		getP().fill(getC());
		getP().rect(getX(), getY(), getWidth(), getHeight(), BUTTON_CURVE);

		getP().fill(getTextColor());
		getP().textAlign(getP().CENTER, getP().CENTER);
		getP().textSize(getTextSize());
		getP().text(getText(), getX() + getWidth() / 2, getY() + getHeight() / 2);
	}

	public boolean clicked()
	{
		if (getP().mouseX > getX() && getP().mouseX < getX() + getWidth() && getP().mouseY > getY() && getP().mouseY < getY() + getHeight())
		{
			getOnClick().run();
			return true;
		}
		else
		{
			return false;
		}
	}
}
