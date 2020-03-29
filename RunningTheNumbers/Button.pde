public class Button extends DrawnText
{
  private float w;
  private float h;
  private String text;
  private Runnable onClick;
  
  public Button(float x, float y, float w, float h, color c, String text, float textSize, color textColor, Runnable onClick)
  {
    super(x, y, c, textSize, textColor);
    
    this.w = w;
    this.h = h;
    
    this.text = text;
    this.onClick = onClick;
  }
  
  public void update()
  {
    
  }
  
  public void display()
  {
    fill(getC());
    rect(getX(), getY(), w, h, BUTTON_CURVE);
    
    fill(getTextColor());
    textAlign(CENTER, CENTER);
    textSize(getTextSize());
    text(text, getX() + w/2, getY() + h/2);
  }
  
  public boolean clicked()
  {
    if(mouseX > getX() && mouseX < getX() + w && mouseY > getY() && mouseY < getY() + h)
    {
      onClick.run();
      return true;
    }
    else
    {
      return false;
    }
  }
  
  public float getWidth() { return w; }
  public void setWidth(float w) { this.w = w; }
  
  public float getHeight() { return h; }
  public void setHeight(float h) { this.h = h; }
  
  public String getText() { return text; }
  public void setText(String text) { this.text = text; }
    
  public Runnable getOnClick() { return onClick; }
  public void setOnClick(Runnable onClick) { this.onClick = onClick; }
}
