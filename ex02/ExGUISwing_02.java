//
// This is an extension of ExGUISwing_01, a window showing a central display and 6 buttons. The display has a border.
//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

//
// - class name: ExGUISwing_02 (file name: ExGUISwing_02.java)
// - super class: ExGUISwing_01 (If you have not finished Step 1, please use ExGUISwing_01_ans instead of ExGUISwing_01, as the super class)
//
public class ExGUISwing_02 extends ExGUISwing_01 {

  // - Use a JButton object for each button
  // - Use a JPanel object and a BevelBorder object for the central display
  // - Create above JButton, JLabel and JPanel objects as attributes for future use.
  protected JButton[]     buttons;
  protected JPanel        panel;
  protected BevelBorder   border;
  // - For showing text on the central display, use JLabel object
  protected JLabel        label;

  final private Integer NUM_BUTTONS = 6;


  //
  // - In the constructor:
  //   (1) Call the constructor of its super class.
  //   (2) Get the Container object of the JFrame  (by getContentPane() of JFrame)
  //   (3) Remove the layout manager of the Container and JPanel objects by calling their setLayout(null).
  //         (This is to control the location and the size of the buttons and text by ourselves)
  //   (4) For each created object:
  //       Set the size (use setSize() method). 
  //       Set the location (use setLocation() method).
  //   (5) For the JPanel object:
  //        Create a BevelBorder object and set it to the JPanel by its setBorder() method.
  //   (6) For the JLabel object:
  //        Create a Font object and set it to the JLabel (use setFont()).
  //   (7) Add the JButton and JPanel objects to the Container object (use add() method).
  //   (8) Change the JLabel object's foreground color to dark green.
  //   (9) Add the JLabel object  to the JPanel object.
  //
  public ExGUISwing_02() {
    // (1) Call the constructor of its super class.
    super();

    // create object
    panel      = new JPanel();
    label      = new JLabel("Power off");
    buttons    = new JButton[NUM_BUTTONS];
    buttons[0] = new JButton("PW");
    buttons[1] = new JButton("AM");
    buttons[2] = new JButton("FM");
    buttons[3] = new JButton("CD");
    buttons[4] = new JButton("Up");
    buttons[5] = new JButton("Down");

    // (2) Get the Container object of the JFrame  (by getContentPane() of JFrame)
    Container container = getContentPane();

    // (3) Remove the layout manager of the Container and JPanel objects by calling their setLayout(null).
    //        (This is to control the location and the size of the buttons and text by ourselves)
    setLayout(null);
    panel.setLayout(null);

    // (4) For each created object:
    //      Set the size (use setSize() method). 
    //      Set the location (use setLocation() method).
    Integer buttonWidth   = 80;
    Integer buttonHeight  = 40;
    Integer panelWidth    = 200;
    Integer panelHeight   = 3 * (buttonHeight + 10) + 3;
    for ( int i = 0; i < 3; ++ i ) {
      buttons[i].setSize(buttonWidth, buttonHeight);
      buttons[i].setLocation(0 + 1, (buttonHeight + 10) * i + 1);
    }
    for ( int i = 3; i < 6; ++ i ) {
      buttons[i].setSize(buttonWidth, 40);
      buttons[i].setLocation(buttonWidth + panelWidth + 1, (buttonHeight + 10) * (i - 3) + 1);
    }
    panel.setSize(panelWidth, panelHeight);
    panel.setLocation(buttonWidth + 1, 1);
    label.setSize(panelWidth, panelHeight);
    label.setLocation(11, 0);

    // (5) For the JPanel object:
    //       Create a BevelBorder object and set it to the JPanel by its setBorder() method.
    border = new BevelBorder(BevelBorder.RAISED);
    panel.setBorder(border);


    // (6) For the JLabel object:
    //       Create a Font object and set it to the JLabel (use setFont()).
    Font f = new Font("Arial", Font.PLAIN, 32);
    label.setFont(f);

    // (7) Add the JButton and JPanel objects to the Container object (use add() method).
    for ( int i = 0; i < NUM_BUTTONS; ++ i ) {
      container.add(buttons[i]);
    }
    container.add(panel);

    // (8) Change the JLabel object's foreground color to dark green.
    label.setForeground(new Color(0, 102, 0));

    // (9) Add the JLabel object  to the JPanel object.
    panel.add(label);
  }

  // - Implement the main() method:
  //   (1) Create a ExGUISwing_02 object.
  //   (2) Call ExGUISwing_02's setVisible() with parameter "true".
  public static void main(String argv[]) {
    // (1) Create a ExGUISwing_02 object.
    JFrame f = new ExGUISwing_02();

    // (2) Call ExGUISwing_02's setVisible() with parameter "true".
    f.setVisible(true);
  }

}

