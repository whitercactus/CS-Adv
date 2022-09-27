import java.util.ArrayList;
import java.awt.Graphics;

public class Level {
  private ArrayList<Entity> gameObjects;

  public Level() {
    gameObjects = new ArrayList<Entity>();
    gameObjects.add(new Player());
  }

  public void render(Graphics g) {
    gameObjects.forEach((Entity e) -> {
      e.render(g);
      e.update();
    });
  }

  public void update() {
    
  }
}