import java.util.*;
public class ShortStringsTest {
  public static void main(String[] args) {
    LinkedList<String> myList = new LinkedList<String>();
    myList.add("First String");
    myList.add("Second Second String");
    myList.add("Third Third Third String");
    myList.add("Fourth Fourth Fourth Fourth String");
    myList.add("Fifth Fifth Fifth Fifth Fifth String");
    
    ShortStrings myShort = new ShortStrings(myList.iterator(), 25);
    // for (String val : myShort) 
    while(myShort.hasNext()) {
      System.out.println("Short String = " + myShort.next());
    }
  }
}
