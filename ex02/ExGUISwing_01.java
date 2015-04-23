//
// Create a simple window with title "ExGUISwing-01" but showing nothing on its contents area .
//

import java.awt.*;
import java.awt.event.*;

// - Import javax.swing.JFrame class at the beginning of your file.
import javax.swing.JFrame;

//
// - class name: ExGUISwing_01 (file name: ExGUISwing_01.java)
// - super class: JFrame
//
public class ExGUISwing_01 extends JFrame {

  final Integer WIDTH  = 640;
  final Integer HEIGHT = 480;

  //
  // - In the constructor:
  //   (1) Call the constructor of JFrame with a title string.
  //   (2) Set the initial size of the window (by setSize() of JFrame) .
  //   (3) Call the setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) for
  //       termination of the program when the window is closed.
  //
  public ExGUISwing_01() {
    // (1) Call the constructor of JFrame with a title string.
    super("ExGUISwing_01");

    // (2) Set the initial size of the window (by setSize() of JFrame) .
    setSize(WIDTH, HEIGHT);

    // (3) Call the setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) for
    //     termination of the program when the window is closed.
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }


  //
  // - Implement the main() method:
  //   (1)  It must be the following format 
  //        "public static void main(String argv[ ])".
  //   (2) Create a ExGUISwing_01 object.
  //   (3) Call ExGUISwing_01's setVisible() with parameter "true". 
  //
  // (1)  It must be the following format 
  //      "public static void main(String argv[ ])".
  public static void main(String argv[]) {
    // (2) Create a ExGUISwing_01 object.
    JFrame f = new ExGUISwing_01();

    // (3) Call ExGUISwing_01's setVisible() with parameter "true". 
    f.setVisible(true);
  }

}

