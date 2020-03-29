public class AllDrawn
{
  private ArrayList<Drawn> allDrawn;
  
  public AllDrawn()
  {
    allDrawn = new ArrayList<Drawn>();
  }
  
  public void update()
  {
    for(Drawn d : allDrawn)
    {
      d.update();
    }
  }
  
  public void display()
  {
    for(Drawn d : allDrawn)
    {
      d.display();
    }
  }
  
  public void addDrawn(Drawn d)
  {
    allDrawn.add(d);
  }
  
  public void setColors(color c, color textColor)
  {
    for(Drawn d : allDrawn)
    {
      if(d instanceof DrawnColor)
      {
        ((DrawnColor) d).setC(c);
      }
      
      if(d instanceof DrawnText)
      {
        ((DrawnText) d).setTextColor(textColor);
      }
    }
  }
  
  public ArrayList<Drawn> getAllDrawn() { return allDrawn; }
  public void setAllDrawn(ArrayList<Drawn> allDrawn) { this.allDrawn = allDrawn; }
}