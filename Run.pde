public class Run implements Comparable
{
  private String runner;
  
  private Time time;
  private int place;
  
  private String location;
  private Date date;
  
  public Run(String runner, Time time, int place, String location, Date date)
  {
    this.runner = runner;
    this.time = time;
    this.place = place;
    this.location = location;
    this.date = date;
  }
  
  public int compareTo(Object other)
  {
    Run temp = (Run) other;
    
    return time.compareTo(temp.getTime());
  }
  
  public String getRunner()
  {
    return runner;
  }
  
  public Time getTime()
  {
    return time;
  }
  
  public int getPlace()
  {
    return place;
  }
  
  public String getLocation()
  {
    return location;
  }
  
  public Date getDate()
  {
    return date;
  }
}
