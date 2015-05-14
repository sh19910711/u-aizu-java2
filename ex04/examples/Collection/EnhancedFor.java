import java.util.Vector;

public class EnhancedFor {
  public static void main(String[] args) {
    int[] intdata = {1,2,3,4,5 };

    Vector<String> vdata = new Vector<String>();
    vdata.add("First");
    vdata.add("Second");
    vdata.add("Third");
    vdata.add("Fourth");
    vdata.add("Fifth");

    for (int i : intdata)  System.out.println("intdata: " + i);

    for (String s : vdata)  System.out.println("Vector data: " + s);
    
  }
}
