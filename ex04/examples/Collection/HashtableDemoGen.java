import java.util.*;
class HashtableDemoGen {

  public static void main(String args[]) {

    Hashtable<String,String> hashtable = new Hashtable<String,String>();
    hashtable.put("apple", "red");
    hashtable.put("strawberry", "red");
    hashtable.put("lime", "green");
    hashtable.put("banana", "yellow");
    hashtable.put("orange", "orange");
//    hashtable.put("orange", new Integer(20));

    for (Enumeration<String> e = hashtable.keys() ; e.hasMoreElements() ;) {
      String k = e.nextElement();
      String v = hashtable.get(k);
      System.out.println("key = " + k +
         "; value = " + v);
     }

    System.out.print("\nThe color of an apple is: ");
    String v = hashtable.get("apple");
    System.out.println(v);
  }
}

