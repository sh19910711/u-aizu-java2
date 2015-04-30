import java.util.ArrayList;

/**
 * ToyBox Example.
 */


class ToyBox<T> {

    private ArrayList<T> v ..... // Complete here to assign ArrayList object         

    public void add() {
        .......    // Complete add method with proper argument and method body                     
    }

    public T get() {
        .......    // Complete get method with proper argument and method body                     
    }

    public int getSize() {
        .......    // Complete getSize method with proper argument and method body                     
    }
}

public class ToyBoxTest {
    public static void showToysinBox(/* Parameter with bounded wildcard to accept Toy and its subclasses*/) {
        .......    // Complete showAnimalsinToyBox method with proper argument and method body                     
    }

    public static void main(String[] args) {

     // Create a "carBox" with proper sentence
       ........................................

       Car t1 = new Car("Yaris", 1500);
       Car t2 = new Car("Corolla", 2500);
      carBox.add(t1);
      carBox.add(t2);
      showToysinBox(carBox);

     // Create a "bearBox" with proper sentence
       ........................................
       Bear b1 = new Bear("Bear1", 1000);
       Bear b2 = new Bear("Bear2", 2000);
      bearBox.add(b1);
      bearBox.add(b2);
      showToysinBox(bearBox);


      /* It is OK till now */

      // Next, create Box<Toy>

     // Create a "toyBox" with proper sentence
       ........................................

       Car t3 = new Car("Tacoma", 3300);
       Bear b3 = new Bear("Bear3", 1200);

      toyBox.add(t3);
      toyBox.add(b3);

      showToysinBox(toyBox);
      /* It is still OK till now */

      // How about the next? Is it subtype?
      ToyBox</* Fill in here with proper wildcard */> sometoyBox = carBox;
      System.out.println("After assigning the carBox into the \"sometoyBox\"...");
      showToysinBox(sometoyBox);
    }
}

class Toy {
  // Complete Toy Class
}

// Car class and Bear class to extend the Toy class


