public class Util
{
  private int[] monthToDays = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
  
  //Number of dots in the dotted lines.
  final int DOTTED_LINE_COUNT = 75;
  
  //Converts a decimal value of a time in minutes (17.016666666) to a time in minutes:seconds (17:01).
  public String constructTime(float formatted)
  {
    String time = "";
     
    int minutes = (int) formatted;
    time += minutes + ":";
      
    int seconds = (int) Math.round((formatted - minutes) * 60);
      
    if(seconds < 10)
    {
      time += "0";
    }
      
    time += seconds;
      
    return time;
  }
    
  //Converts a minutes:seconds time (17:01) to a decimal value in minutes (17.016666666).
  public float parseTime(String time)
  {
    float formatted = 0.0;
      
    String minutes = time.split(":")[0];
    String seconds = time.split(":")[1];
      
    formatted += Float.parseFloat(minutes);
    formatted += Float.parseFloat(seconds) / 60;
      
    return formatted;
  }
  
  public Time findAverageTime(ArrayList<Run> performances)
  {
    float total = 0.0;
  
    for(int i = 0; i < performances.size(); i++)
    {
      total += performances.get(i).getTime().getMinuteDecimal();
    }
  
    return new Time(total / performances.size());
  }
  
  public Run findPR(ArrayList<Run> performances)
  {
    Run pr = performances.get(0);
    
    for(int i = 1; i < performances.size(); i++)
    {
      if(performances.get(i).getTime().getMinuteDecimal() < pr.getTime().getMinuteDecimal())
      {
        pr = performances.get(i);
      }
    }
    
    return pr;
  }
  
  public int[] getMonthToDays()
  {
    return monthToDays;
  }
  
  //Draws a dotted line with the dimensions specified.
  public void dottedLine(float x1, float y1, float x2, float y2)
  {
    float dx = (x2 - x1) / (DOTTED_LINE_COUNT * 2);
    float dy = (y2 - y1) / (DOTTED_LINE_COUNT * 2);
    
    float initialX = x1;
    float initialY = y1;
    
    for(int i = 1; i <= DOTTED_LINE_COUNT; i++)
    {
      line(initialX, initialY, initialX + dx, initialY + dy);
      initialX += 2 * dx;
      initialY += 2 * dy;
    }
  }
}
