import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Input implements KeyListener {
  private static Input instance;

  public static Input get() {
    if (instance == null) {
      instance = new Input();
    }

    return instance;
  }

  private HashMap<Integer, Boolean> upKeys, downKeys, pressedKeys;

  private Input() {
    upKeys = new HashMap<Integer, Boolean>();
    downKeys = new HashMap<Integer, Boolean>();
    pressedKeys = new HashMap<Integer, Boolean>();
  }

  @Override
  public void keyPressed(KeyEvent e) {
    downKeys.put(e.getKeyCode(), true);
    pressedKeys.put(e.getKeyCode(), false);
    upKeys.put(e.getKeyCode(), false);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    downKeys.put(e.getKeyCode(), false);
    pressedKeys.put(e.getKeyCode(), false);
    upKeys.put(e.getKeyCode(), true);
  }

  @Override
  public void keyTyped(KeyEvent e) {
    downKeys.put(e.getKeyCode(), false);
    pressedKeys.put(e.getKeyCode(), true);
    upKeys.put(e.getKeyCode(), false);
  }

  public boolean isKeyDown(int k) {
    return downKeys.get(k);
  }
  
  public boolean isKeyUp(int k) {
    return upKeys.get(k);
  }

  public boolean isKeyPressed(int k) {
    return pressedKeys.get(k);
  }
}