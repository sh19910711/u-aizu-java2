import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="ExGUIAWT_02" archive="build/ex01.jar"
  width="400" height="400"></applet>
 */

public class ExGUIAWT_02 extends ExGUIAWT_01 implements ActionListener {

  // To increase or decrease the count number
  private final Integer OFFSET = 1;

  private Button plusButton;
  private Button minusButton;

  // The number and the label should be declared as protected attributes for subclasses.
  protected Label counter;
  protected Integer count;

  // Override Applet's init() method:
  public void init() {
    // (1) call super class's init() method.
    super.init();

    count = 0;

    // (2) Place the buttons and the label on the Applet (use add());
    createObjects();
    addObjects();
    updateCounter();

    // (3) Add action listener (this) to each button (use addActionListener(this)).
    //     That is, we use one listener to catch events from all the buttons.
    addListeners();
  }

  // (2)
  private void createObjects() {
    plusButton = new Button("+");
    minusButton = new Button("-");
    counter = new Label("");
  }

  // (2)
  private void addObjects() {
    add(minusButton);
    add(counter);
    add(plusButton);
  }

  // (2)
  protected void updateCounter() {
    counter.setText(String.format("%d", count));
  }

  // (3)
  private void addListeners() {
    plusButton.addActionListener(this);
    minusButton.addActionListener(this);
  }

  // Implement the actionPerformed() method for ActionListener
  public void actionPerformed(ActionEvent e) {
    // (1) Get the source object on which the event occurred (call getSource() of the argument).
    Object o = e.getSource();

    // (2) The source object should be one of the buttons saved in the attributes.
    //     Therefore, you can know which button has been clicked by comparing the button attributes with the source object.
    // (3) Increase or decrease the number according to the clicked butten.
    // (4) Set the number to the label (call Label setText() method).
    //     -> updateCounter()
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
