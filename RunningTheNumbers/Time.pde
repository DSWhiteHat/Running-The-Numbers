public class Time implements Comparable
{
  private String minuteSecond;
  private float minuteDecimal;
  private Util helper;
  
  public Time(String minuteSecond)
  {
    this.minuteSecond = minuteSecond;
    minuteDecimal = helper.parseTime(minuteSecond);
  }
  
  public Time(float minuteDecimal)
  {
    this.minuteDecimal = minuteDecimal;
    minuteSecond = helper.constructTime(minuteDecimal);
  }

  public int compareTo(Object other)
  {
    Time temp = (Time) other;
    
    if(minuteDecimal == temp.getMinuteDecimal())
    {
      return 0;
    }
    else if(minuteDecimal > temp.getMinuteDecimal())
    {
      return 1;
    }
    else
    {
      return -1;
    }
  }
  
  public String getMinuteSecond() { return minuteSecond; }
  public float getMinuteDecimal() { return minuteDecimal; }
}
