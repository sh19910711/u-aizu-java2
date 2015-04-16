import java.applet.Applet;
import java.awt.*;

/*
<applet code="ExGUIAWT_01" archive="build/ex01.jar"
  width="400" height="400"></applet>
 */

public class ExGUIAWT_01 extends Applet {

  public void init() {
    resize(400, 300);
  }

  public void paint(Graphics g) {
    g.drawString("April 16, 2015", 150, 150);
    g.setColor(Color.red);
    g.drawArc(100, 50, 200, 200, 0, 360);
  }

}
