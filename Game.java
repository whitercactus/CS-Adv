import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

  public int width, height, fps = 60;
  private String title;
  public Display display;

  public Thread thread;
  public boolean running = false;
  private BufferStrategy bs;
  private Input input;
  private Graphics g;

  private Level currentLevel;

  public Game(int width, int height, String title) {
    this.width = width;
    this.height = height;
    this.title = title;
  }

  private void init() {
    display = new Display(width, height, title);
    input = new Input();
    display.frame.addKeyListener(input);
    currentLevel = new Level();
  }

  private void tick() {
    currentLevel.update();
  }

  private void render() {
    bs = display.canvas.getBufferStrategy();
    if (bs == null) {
      display.canvas.createBufferStrategy(3);
      return;
    }

    g = bs.getDrawGraphics();
    g.clearRect(0, 0, width, height);

    currentLevel.render(g);

    bs.show();
    g.dispose();
  }

  public void run() {
    init();

    double tickDuration = 1000000000 / fps;
    double delta = 0;
    long now;
    long lastTime = System.nanoTime();

    while (running) {
      now = System.nanoTime();
      delta += (now - lastTime) / tickDuration;
      lastTime = now;

      if (delta >= 1) {
        tick();
        render();
        delta--;
      }
    }

    stop();
  }

  public synchronized void start() {
    if (running)
      return;
    running = true;
    thread = new Thread(this);
    thread.start();
  }

  public synchronized void stop() {
    if (!running)
      return;
    running = false;
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}