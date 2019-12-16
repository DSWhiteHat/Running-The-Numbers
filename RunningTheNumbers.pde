/*
Daniel Stebbins, Cedar Crest High School, Began 11/20/19. 7hrs.
This project is my own work, D.S.
This program is an interactive visualization tool for cross country team statistics across multiple years. Programmed for Cedar Crest Cross Country.
*/

/*
TODO:
Button Class
Year Class
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
*/

//Overall window dimensions.
final int WIDTH = 1200;
final int HEIGHT = 600;

//Coordinates of top-left corner of the performance chart.
final int CHARTX = 75;
final int CHARTY = 25;

//Amount of the screen the chart takes up. (Percentage values in decimal form, for instance .6 = 60%)
final float CHARTX_MULTIPLIER = .5;
final float CHARTY_MULTIPLIER = .5;

//Text font sizes.
final int LABEL_SIZE = 14;
final int TITLE_SIZE = 32;

final Util HELPER = new Util();

//File reader to retrieve team data.
//final BufferedReader READER = createReader("/Users/Vicky Brown/Desktop/RunningTheNumbers/RunningNumbers.txt");

//The upper and lower year values displayed on the chart.
int startYear = 2014;
int endYear = 2019;

//The upper and lower time values displayed on the chart.
float fastTime = HELPER.parseTime("15:00");
float slowTime = HELPER.parseTime("19:00");

//The amount of time between each marked interval on the chart.
float timeIncrement = HELPER.parseTime("00:30");

//Dark mode initial color scheme.
boolean darkMode = true;
color backgroundColor = #202020;
color pageElementColor = #8f8f8f;

/*
//Light mode initial color scheme.
boolean darkMode = false;
color backgroundColor = #bbbbbb;
color pageElementColor = #000000;
*/

//Sets basic values of the sketch before it runs.
void setup()
{
  size(1200, 600);
}

//Ticks, displaying the current program page.
void draw()
{
  background(backgroundColor);
  chartSetup();
}

//Switches the color scheme from dark mode to light mode or from light mode to dark mode. Called by a toggle button press.
void switchColors()
{
  if(darkMode)
  {
    darkMode = false;
    backgroundColor = #ffffff;
    pageElementColor = #000000;
  }
  else
  {
    darkMode = true;
    backgroundColor = #202020;
    pageElementColor = #8f8f8f;
  }
}

//Draws the chart on which the running data is displayed.
void chartSetup()
{
  stroke(pageElementColor);
  textAlign(CENTER);
  textSize(LABEL_SIZE);
  
  //Vertical lines on the chart, each corresponding to a year value displayed on the bottom.
  float offset = (WIDTH * CHARTX_MULTIPLIER) / (endYear - startYear + 2);
  for(int i = 0; i <= endYear - startYear; i++)
  {
    line(CHARTX + offset * (i + 1), CHARTY, CHARTX + offset * (i + 1), HEIGHT * CHARTY_MULTIPLIER + CHARTY);
    text(startYear + i, CHARTX + offset * (i + 1), HEIGHT * CHARTY_MULTIPLIER + CHARTY + 25); 
  }
  
  //Horizontal lines on the chart, each corresponding to a time value displayed on the lefthand side.
  offset = (HEIGHT * CHARTY_MULTIPLIER) * timeIncrement / (slowTime - fastTime);
  for(int i = 0; i <= (slowTime - fastTime) / timeIncrement; i++)
  {
    HELPER.dottedLine(CHARTX, CHARTY + offset * i, WIDTH * CHARTX_MULTIPLIER + CHARTX, CHARTY + offset * i);
    text(HELPER.constructTime(slowTime - timeIncrement * i), CHARTX - 30, CHARTY + offset * i + LABEL_SIZE * .5); 
  }
  
  //Vertical lines on the two sides of the chart.
  line(CHARTX, CHARTY, CHARTX, HEIGHT * CHARTY_MULTIPLIER + CHARTY);
  line(WIDTH * CHARTX_MULTIPLIER + CHARTX, CHARTY, WIDTH * CHARTX_MULTIPLIER + CHARTX, HEIGHT * CHARTY_MULTIPLIER + CHARTY);
  
  //Horizontal lines at the top and bottom of the chart.
  line(CHARTX, CHARTY, WIDTH * CHARTX_MULTIPLIER + CHARTX, CHARTY);
  line(CHARTX, HEIGHT * CHARTY_MULTIPLIER + CHARTY, WIDTH * CHARTX_MULTIPLIER + CHARTX, HEIGHT * CHARTY_MULTIPLIER + CHARTY);
}
