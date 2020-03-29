public class Slider extends Button
{
  public Slider(float x, float y, float w, float h, color c, String text, float textSize, color textColor, Runnable onClick)
  {
    super(x, y, w, h, c, text, textSize, textColor, onClick);
  }
  
  public void display()
  {
    fill(getC());
    rect(getX(), getY(), getWidth(), getHeight(), BUTTON_CURVE);
    
    fill(getTextColor());
    textAlign(CENTER, CENTER);
    textSize(getTextSize());
    text(getText(), getX() + getWidth() / 2, getY() + getHeight() / 2);
  }
  
  public boolean clicked()
  {
    if(mouseX > getX() && mouseX < getX() + getWidth() && mouseY > getY() && mouseY < getY() + getHeight())
    {
      getOnClick().run();
      return true;
    }
    else
    {
      return false;
    }
  }
}
