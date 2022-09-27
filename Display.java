import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Display {

  public JFrame frame;
  public Canvas canvas;
  public int width, height;

  public Display(int width, int height, String title) {
    this.width = width;
    this.height = height;

    frame = new JFrame();
    frame.setTitle(title);
    frame.setSize(width, height);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    canvas = new Canvas();
    canvas.setPreferredSize(new Dimension(width, height));
    canvas.setMinimumSize(new Dimension(width, height));
    canvas.setMaximumSize(new Dimension(width, height));

    frame.add(canvas);
    frame.pack();
  }
}