package com.daniel.display;

import processing.core.PApplet;

public class GraphicsHelper
{
	// Number of dots in the dotted lines.
	private final static int DOTTED_LINE_COUNT = 75;
	
	// Draws a dotted line with the dimensions specified.
	public static void dottedLine(PApplet p, float x1, float y1, float x2, float y2)
	{
		float dx = (x2 - x1) / (DOTTED_LINE_COUNT * 2);
		float dy = (y2 - y1) / (DOTTED_LINE_COUNT * 2);

		float initialX = x1;
		float initialY = y1;

		for (int i = 1; i <= DOTTED_LINE_COUNT; i++)
		{
			p.line(initialX, initialY, initialX + dx, initialY + dy);
			initialX += 2 * dx;
			initialY += 2 * dy;
		}
	}
}
