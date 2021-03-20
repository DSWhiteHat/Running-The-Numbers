/*
Daniel Stebbins, Cedar Crest High School, Began 11/20/19. 39hrs.
This project is my own work, D.S.
This program is an interactive visualization tool for cross country team statistics across multiple years. Programmed for Cedar Crest Cross Country.
*/

/*
TODO:
~Button Class
?Year Class
~Runner Class
~Date Class
~Meet Class
~Run Class
Text Output on right hand side.
Control panel bellow chart.
CSV parsing for team data.
Different axis labels.
Main menu screen.
Settings screen.
Parsing screen.

More immediate TODO:
Make ? Times work.
Make team places work with team scores.

Scrubbing list:
Remove trailing commas from the file
Remove extra spaces
Remove word "Conditions"
Times with both :00 and 24;32 (semicolon) (Cheats to stop Excel from being dumb.)
Remove spaces near semicolons as well.
*/

package com.daniel.main;

import com.daniel.display.Runnable;

import java.util.HashMap;

import com.daniel.display.AllDrawn;
import com.daniel.display.Button;
import com.daniel.display.Drawn;
import com.daniel.display.Graph;
import com.daniel.display.Image;
import com.daniel.display.Page;

import processing.core.PApplet;
import processing.core.PImage;

public class RunningTheNumbers extends PApplet
{
	// Overall window dimensions. NEEDED???
	public static int WIDTH = 1200;
	public static int HEIGHT = 800;

	// Coordinates of top-left corner of the performance chart.
	public static final int CHARTX = 75;
	public static final int CHARTY = 25;

	// Amount of the screen the chart takes up. (Percentage values in decimal form,
	// for instance .6 = 60%)
	public static final float CHARTX_MULTIPLIER = .5f;
	public static final float CHARTY_MULTIPLIER = .5f;

	// Text font sizes.
	public static final int LABEL_SIZE = 14;
	public static final int TITLE_SIZE = 50;

	// File reader to retrieve team data.
	// final BufferedReader READER = createReader("/Users/VickyBrown/Desktop/RunningTheNumbers/RunningNumbers.txt");

	// Dark mode initial color scheme.
	boolean darkMode = true;
	public int backgroundColor = 0xff202020;
	public int elementColor = 0xff8f8f8f;
	public int textColor = 0xffcccccc;

	private HashMap<String, Page> pages = new HashMap<String, Page>();
	private Page page;

	/*
	 * Light mode initial color scheme. boolean darkMode = false; color backgroundColor = #bbbbbb; color pageElementColor = #000000;
	 */

	// Sets most basic settings.
	public void settings()
	{
		size(1200, 800);
	}

	// Sets slightly less basic values of the sketch before it runs.
	public void setup()
	{
		/* Graph Stuff
		 * drawn.addDrawn(new Button(100, HEIGHT - 125, this, 100, 25, elementColor, "Color Mode", 12, textColor, new Runnable() { public
		 * void run() { switchColors(); } })); drawn.addDrawn(new Graph(CHARTX, CHARTY, this, WIDTH * CHARTX_MULTIPLIER, HEIGHT *
		 * CHARTY_MULTIPLIER, elementColor, LABEL_SIZE, textColor));
		 */
		surface.setResizable(true);
		pages.put("Main Menu", new Page(0, 0, this, backgroundColor, TITLE_SIZE, textColor, "Running the Numbers", new AllDrawn()));
		page = pages.get("Main Menu");
		
		page.addDrawn(new Image(0, 0, this, loadImage("Data/Track.jpg"), 1, 1));
		page.addDrawn(new Image(0, .075f, this, loadImage("Data/Blank Banner.png"), 1, .15f));
		//page.addDrawn(new Image(0, 0, this, loadImage("Data/Running the Numbers.png"), 1, .2f));
	}

	// Ticks, displaying the current program page.
	public void draw()
	{
		background(backgroundColor);

		page.update();
		page.display();
	}

	// TODO
	public void mousePressed()
	{
		for (Drawn d : page.getDrawn().getAllDrawn())
		{
			if (d instanceof Button)
			{
				((Button) d).clicked();
			}
		}
	}

	// Switches the color scheme from dark mode to light mode or from light mode to dark mode. Called by a toggle button press.
	void switchColors()
	{
		if (darkMode)
		{
			darkMode = false;
			backgroundColor = 0xffcccccc;
			textColor = 0xff000000;
		}
		else
		{
			darkMode = true;
			backgroundColor = 0xff202020;
			textColor = 0xffffffff;
		}
		
		//Need to make pages retrieve global values for themselves.
	}
}