public class Graph extends DrawnText
{

  private float w;
  private float h;
  
  public Graph(float x, float y, float w, float h, color c, float textSize, color textColor)
  {
    super(x, y, c, textSize, textColor);
    this.w = w;
    this.h = h;
  }
  
  public void update()
  {
    
  }
  
  //Draws the chart on which the running data is displayed.
  public void display()
  {
    stroke(getC());
    textAlign(CENTER, TOP);
    textSize(getTextSize());
    
    //Vertical lines on the chart, each corresponding to a year value displayed on the bottom.
    float offset = w / (endYear - startYear + 2);
    for(int i = 0; i <= endYear - startYear; i++)
    {
      line(getX() + offset * (i + 1), getY(), getX() + offset * (i + 1), h + getY());
      text(startYear + i, getX() + offset * (i + 1), h + getY()); 
    }
    
    //Horizontal lines on the chart, each corresponding to a time value displayed on the lefthand side.
    offset = h * timeIncrement / (slowTime - fastTime);
    for(int i = 0; i <= (slowTime - fastTime) / timeIncrement; i++)
    {
      HELPER.dottedLine(getX(), getY() + offset * i, w + getX(), getY() + offset * i);
      
      textAlign(RIGHT);
      text(HELPER.constructTime(slowTime - timeIncrement * i), getX() - 10, getY() + offset * i + getTextSize() * .5); 
    }
    
    //Vertical lines on the two sides of the chart.
    line(getX(), getY(), getX(), h + getY());
    line(w + getX(), getY(), w + getX(), h + getY());
    
    //Horizontal lines at the top and bottom of the chart.
    line(getX(), getY(), w + getX(), getY());
    line(getX(), h + getY(), w + getX(), h + getY());
  }
}
