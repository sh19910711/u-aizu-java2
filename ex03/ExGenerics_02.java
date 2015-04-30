import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/*
<applet code = "ExGenerics_02" archive="build/ex03.jar" width=400 height=400></applet>
*/

// Now, we want to make correction of the code that raises the exception in the ExGenerics_01.java. Finish this work as follows:
//
// - (Here, ExGenerics_02.java is a copy of ExGenerics_01.java. Change ExGenerics_02.java only)
// - See that there is no warning message but only compile error messages form the compiler.
// - See that there would be no running error if you had completely removed compiler errors.

public class ExGenerics_02 extends Applet{
  // - Use a generic type of ArrayList instead of its raw type.
	ArrayList<String> num_list = new ArrayList<>();

	public void init(){
		this.setSize(400, 300);
		num_list.add("1200");
		// num_list.add(new Point(300, 100));
		// num_list.add(1300);
		num_list.add("1400");
		num_list.add("1500");
		num_list.add("1600");
	}

	public void paint(Graphics g){
		super.paint(g);

		for(int ii = 0 ; ii < num_list.size() ; ii++){
      // - Remove all the type cast (we do not need them)
			String s = num_list.get(ii);
			g.drawString(s, 100, (ii+1)*20);
		}
	}

}
