public class Runner
{
  private String name;
  private ArrayList<Run> performances;
  private Run pr;
  private Time averageTime;
  private Util helper;
  
  public Runner(String name)
  {
    this.name = name;
    performances = new ArrayList<Run>();
  }
  
  public Runner(String name, ArrayList<Run> performances)
  {
    this.name = name;
    this.performances = performances;
    averageTime = helper.findAverageTime(performances);
    pr = helper.findPR(performances);
  }
  
  public String getName()
  {
    return name;
  }
  
  public ArrayList<Run> getPerformances()
  {
    return performances;
  }
  
  public Run getPR()
  {
    return pr;
  }
  
  public Time getAverageTime()
  {
    return averageTime;
  }
}
