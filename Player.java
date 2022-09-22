import java.awt.Graphics;
import java.awt.Color;

public class Player extends Entity {
  private int hp;

  public Player() {
    
  }
  
  @Override
  public void render(Graphics g) {
    g.setColor(Color.blue);
    g.fillRect(x, y, 50, 50);
  }

  @Override
  public void update() {
    
  }
}