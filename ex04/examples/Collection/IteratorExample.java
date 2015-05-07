import java.util.*;

class MyArray implements Iterable<String> {

    private String[] v = new String[10];          
    private int ptr = 0;

    public void add(String t) {
        v[ptr++] = t; 
    }

    public String get(int i) {
        String a = v[ptr];
        return a; 
    }

    public int getSize() {
        return ptr;
    }

    public Iterator<String> iterator() {
        return new MyIterator();
    }

  private class MyIterator implements Iterator<String> {
      int idx;
      // Constructor
      public MyIterator() {
        idx = 0;
      }

      public boolean hasNext() {
        return idx < ptr ;
      }

      public String next() {
        if(idx >= ptr) 
          throw new java.util.NoSuchElementException();

        String element = v[idx];
        idx++;
        return element;
      }

      public void remove() {
        // we think there will not be remove invocation.
      }
  } // end of MyIterator

} // end of MyArray

public class IteratorExample {
     public static void main(String[] args) {
      MyArray str = new MyArray();
    
      str.add("This");      str.add("is");
      str.add("a");         str.add("test");
      str.add("string.");

      for(String s : str) 
         System.out.print(s + " ");
      System.out.println();
    }
}



