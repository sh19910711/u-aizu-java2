import java.util.*;
class HashtableDemo {

  public static void main(String args[]) {

    Hashtable<String, String> hashtable = new Hashtable<String, String>();
    hashtable.put("apple", "red");
    hashtable.put("strawberry", "red");
    hashtable.put("lime", "green");
    hashtable.put("banana", "yellow");
    hashtable.put("orange", "orange");
 
    String ans = (String) hashtable.get("orange");
    System.out.println("Color of orange is " + ans);

  }

}

/*
    Enumeration e = hashtable.keys();
    while(e.hasMoreElements()) {
      Object k = e.nextElement();
      Object v = hashtable.get(k);
      System.out.println("key = " + k +
         "; value = " + v);
    } 
    System.out.print("\nThe color of an apple is: ");
    Object v = hashtable.get("apple");
    System.out.println(v);
  }
}
*/

