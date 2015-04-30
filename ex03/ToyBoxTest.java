import java.util.ArrayList;

/**
 * ToyBox Example.
 */

// (2) There is an incomplete code "ToyBoxTest.java" on your work directory.
// It has a generic type "ToyBox", and shows some ways how to use this type. Complete the code to show the same result as ToyBoxTestAnswer does. 

class ToyBox<T> {

  private ArrayList<T> v = new ArrayList<T>(); // DONE: Complete here to assign ArrayList object

  public void add(T t) {
    // DONE: Complete add method with proper argument and method body
    v.add(t);
  }

  public T get(int i) {
    // DONE: Complete get method with proper argument and method body
    return v.get(i);
  }

  public int getSize() {
    // DONE: Complete getSize method with proper argument and method body
    return v.size();
  }
}

public class ToyBoxTest {
  /* Parameter with bounded wildcard to accept Toy and its subclasses*/
  public static void showToysinBox(ToyBox<? extends Toy> box) {
    // DONE: Complete showAnimalsinToyBox method with proper argument and method body
    for ( int i = 0; i < box.getSize(); ++ i ) {
      System.out.println(box.get(i));
    }
  }

  public static void main(String[] args) {

    // DONE: Create a "carBox" with proper sentence
    ToyBox<Car> carBox = new ToyBox<Car>();

    Car t1 = new Car("Yaris", 1500);
    Car t2 = new Car("Corolla", 2500);
    carBox.add(t1);
    carBox.add(t2);
    showToysinBox(carBox);

    // DONE: Create a "bearBox" with proper sentence
    ToyBox<Bear> bearBox = new ToyBox<Bear>();

    Bear b1 = new Bear("Bear1", 1000);
    Bear b2 = new Bear("Bear2", 2000);
    bearBox.add(b1);
    bearBox.add(b2);
    showToysinBox(bearBox);


    /* It is OK till now */

    // Next, create Box<Toy>

    // Create a "toyBox" with proper sentence
    ToyBox<Toy> toyBox = new ToyBox<Toy>();

    Car t3 = new Car("Tacoma", 3300);
    Bear b3 = new Bear("Bear3", 1200);

    toyBox.add(t3);
    toyBox.add(b3);

    showToysinBox(toyBox);
    /* It is still OK till now */

    // How about the next? Is it subtype?
    ToyBox<? extends Toy> sometoyBox = carBox; /* Fill in here with proper wildcard */
    System.out.println("After assigning the carBox into the \"sometoyBox\"...");
    showToysinBox(sometoyBox);
  }
}

class Toy {
  protected String name;
  protected Integer price;

  // Complete Toy Class
  public Toy(String name, Integer price) {
    this.name = name;
    this.price = price;
  }

  public String toString() {
    return String.format("%s/%d", name, price);
  }
}

// Car class and Bear class to extend the Toy class
class Car extends Toy {
  public Car(String name, Integer price) {
    super(name, price);
  }
}

class Bear extends Toy {
  public Bear(String name, Integer price) {
    super(name, price);
  }
}

