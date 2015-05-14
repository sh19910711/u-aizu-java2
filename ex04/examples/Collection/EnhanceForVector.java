import java.util.Vector;
public class EnhanceForVector {
  public static void main(String[] args){
     Vector<String> vec = new Vector<String>();
     vec.addElement("Apple"); vec.addElement("Orange");
     vec.addElement("Grape");
      for (String item : vec) {
         System.out.println("Item : " + item);
      }
  }
}

