import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="ExGUIAWT_03" archive="build/ex01.jar"
  width="400" height="400"></applet>
 */

// This is an extension of ExGUIAWT_02. 
// By horizontally dragging the mouse on the window, you can chagne the number quickly.
// super class: ExGUIAWT_02
// implement interface: MouseListener, MouseMotionListener
public class ExGUIAWT_03 extends ExGUIAWT_02 implements MouseListener, MouseMotionListener {
  // Use an attribute to save mouse x position.
  private Integer mouseX;

  // Override Applet's init() method:
  public void init() {
    // (1) Call the same method of its supper class;
    super.init();

    // (2) Add listeners (this) to the ExGUIAWT_03 object itself
    //     (use addMouseListener() and addMouseMotionListener()).
    //     That is, we use two listeners to catch events on one object.
    addMouseListener(this);
    addMouseMotionListener(this);
  }

  // Implement methods mousePressed() for MouseListener:
  public void mousePressed(MouseEvent e) {
    // (1) Get mouse x position (call getX() of the argument), save it to the attribute.
    mouseX = e.getX();
  }

  // Implement method mouseDragged() for MouseMotionListener:
  public void mouseDragged(MouseEvent e) {
    // (1) Get mouse x position; Compare it with the attribute (the saved position) to decide how to change the number in super class.
    Integer nextMouseX = e.getX();

    // (2) Set the number to the label in the super class.
    Integer diffX = nextMouseX - mouseX;
    count += diffX;

    // (3) Save current mouse position to the attribute for further use.
    mouseX = nextMouseX;

    updateCounter();
  }

  // Implement the following methods but do nothing:
  // mouseClicked(),  mouseEntered(), mouseExited(), mouseReleased(), and mouseMoved().
  public void mouseClicked  (MouseEvent e) {}
  public void mouseEntered  (MouseEvent e) {}
  public void mouseExited   (MouseEvent e) {}
  public void mouseReleased (MouseEvent e) {}
  public void mouseMoved    (MouseEvent e) {}
}

