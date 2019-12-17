public class Run implements Comparable
{
  private Meet meet;
  private Runner runner;
  private Time time;
  
  public Run(Runner runner, Time time, Meet meet)
  {
    this.meet = meet;
    this.runner = runner;
    this.time = time;
  }
  
  public int compareTo(Object other)
  {
    Run temp = (Run) other;
    
    return time.compareTo(temp.getTime());
  }
  
  public Meet getMeet() { return meet; }
  public Runner getRunner() { return runner; }
  public Time getTime() { return time; }
}
