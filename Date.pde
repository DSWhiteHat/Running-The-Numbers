public class Date implements Comparable
{
  private int month;
  private int day;
  private int year;
  private float comparable;
  
  private Util helper = new Util();
  
  public Date(int month, int day, int year)
  {
    this.month = month;
    this.day = day;
    this.year = year;
    
    findComparable();
  }
  
  public String toString()
  {
    return month + "/" + day + "/" + year;
  }
  
  public int compareTo(Object other)
  {
    Date temp = (Date) other;
    
    if(comparable == temp.getComparable())
    {
      return 0;
    }
    else if(comparable > temp.getComparable())
    {
      return 1;
    }
    else
    {
      return -1;
    }
  }
  
  public float findComparable()
  {
    comparable = year;
    
    float days = day + helper.monthToDays[month - 2];
    
    comparable += (days / 365);
    
    return comparable;
  }
  
  public int getMonth()
  {
    return month;
  }
  
  public int getDay()
  {
    return day;
  }
  
  public int getYear()
  {
    return year;
  }
  
  public float getComparable()
  {
    return comparable;
  }
}
