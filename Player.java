import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Player extends Entity {
  public Player() {
    
  }
  
  @Override
  public void render(Graphics g) {
    g.setColor(Color.blue);
    g.fillRect(x, y, 50, 50);
  }

  @Override
  public void update() {
    if (Input.get().isKeyDown(KeyEvent.VK_W)) {
      System.out.println("Test");
    }
  }
}