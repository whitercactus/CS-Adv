import java.awt.Graphics;

public abstract class Entity {
  protected int x, y;

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public abstract void render(Graphics g);
  public abstract void update();
}