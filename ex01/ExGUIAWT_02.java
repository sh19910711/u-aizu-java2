import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="ExGUIAWT_02" archive="build/ex01.jar"
  width="400" height="400"></applet>
 */

public class ExGUIAWT_02 extends ExGUIAWT_01 implements ActionListener {

  private final Integer OFFSET = 1;

  private Label counter;
  private Button plusButton;
  private Button minusButton;
  private Integer count;

  public void init() {
    super.init();

    count = 0;

    createObjects();
    addListeners();
    addObjects();
    updateCounter();
  }

  private void createObjects() {
    plusButton = new Button("+");
    minusButton = new Button("-");
    counter = new Label("");
  }

  private void addListeners() {
    plusButton.addActionListener(this);
    minusButton.addActionListener(this);
  }

  private void addObjects() {
    add(minusButton);
    add(counter);
    add(plusButton);
  }

  private void updateCounter() {
    counter.setText(String.format("count = %d", count));
  }

  public void actionPerformed(ActionEvent e) {
    Object o = e.getSource();
    if ( o == plusButton ) {
      count += OFFSET;
      updateCounter();
    } else if ( o == minusButton ) {
      count -= OFFSET;
      updateCounter();
    }
    repaint();
  }

  public void print(Graphics g) {
    super.print(g);
    g.drawString("Test", 0, 0);
  }

}
