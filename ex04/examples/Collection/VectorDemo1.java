import java.util.*;

public class VectorDemo1 {

  public static void main(String args[]) {

    // Create a vector and its elements
    Vector vector = new Vector();
    vector.addElement(new Integer(5));
    vector.addElement(new Float(-14.14f));
    vector.addElement(new String("Hello"));
    vector.addElement(new Long(120000000));
    vector.addElement(new Double(-23.45e-11));

    // Display the  vector elements
    System.out.println(vector);

    // Insert an element into the vector
    String s = new String("String to be inserted");
    vector.insertElementAt(s, 1);
    System.out.println(vector);
 
    // Remove an element from the vector
    vector.removeElementAt(3);
    System.out.println(vector);
  }
}

