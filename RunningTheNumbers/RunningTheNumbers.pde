/*
Daniel Stebbins, Cedar Crest High School, Began 11/20/19. 9hrs.
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
final int HEIGHT = 800;

//Coordinates of top-left corner of the performance chart.
final int CHARTX = 75;
final int CHARTY = 25;

//Amount of the screen the chart takes up. (Percentage values in decimal form, for instance .6 = 60%)
final float CHARTX_MULTIPLIER = .5;
final float CHARTY_MULTIPLIER = .5;

//Text font sizes.
final int LABEL_SIZE = 14;
final int TITLE_SIZE = 32;

//Button Curviness
final float BUTTON_CURVE = 5;

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
color elementColor = #8f8f8f;
color textColor = #cccccc;

AllDrawn drawn = new AllDrawn();

/*
Light mode initial color scheme.
boolean darkMode = false;
color backgroundColor = #bbbbbb;
color pageElementColor = #000000;
*/

//Sets basic values of the sketch before it runs.
void setup()
{
  
  drawn.addDrawn(new Button(100, HEIGHT - 125, 100, 25, elementColor, "Color Mode", 12, textColor, new Runnable(){ public void run(){ switchColors(); }}));
  drawn.addDrawn(new Graph(CHARTX, CHARTY, WIDTH * CHARTX_MULTIPLIER, HEIGHT * CHARTY_MULTIPLIER, elementColor, LABEL_SIZE, textColor));
  size(1200, 800);
}

//Ticks, displaying the current program page.
void draw()
{
  background(backgroundColor);
  drawn.update();
  drawn.display();
}

void mousePressed()
{
  for(Drawn d: drawn.getAllDrawn())
  {  
    if(d instanceof Button)
    {
      ((Button) d).clicked();
    }
  }
}

//Switches the color scheme from dark mode to light mode or from light mode to dark mode. Called by a toggle button press.
void switchColors()
{
  if(darkMode)
  {
    darkMode = false;
    backgroundColor = #ffffff;
    textColor = #000000;
  }
  else
  {
    darkMode = true;
    backgroundColor = #202020;
    textColor = #ffffff;
  }
  
  drawn.setColors(elementColor, textColor);
}
