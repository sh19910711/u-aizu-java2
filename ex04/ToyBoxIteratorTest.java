import java.util.*;

class ToyBox<T> implements Iterable<T> /* DONE: Insert code for being iterable class */ {

  private ArrayList<T> v = new ArrayList<T>();          

  public void add(T t) {
    v.add(t);
  }

  public T get(int i) {
    return v.get(i);
  }

  public int getSize() {
    return v.size();
  }

  /* DONE: write code for iterator method -- it returns an object of the ToyBoxIterator */
  public Iterator<T> iterator() {
    return new ToyBoxIterator();
  }

  // ToyBoxIterator class -- inner class
  private class ToyBoxIterator implements Iterator<T> /* DONE: complete here to implment Iterator interface */ {
    int idx; // counter to point current posion of an element of the vector for iterating

    // Constructor
    public ToyBoxIterator() {
      idx = 0;
    }

    // DONE: Method to test whether more elements are available
    public boolean hasNext() {
      return idx < getSize();
    }

    // DONE: Next implement 1) next() method
    public T next() {
      if ( ! hasNext() ) {
        throw new NoSuchElementException();
      }

      T item = get(idx);
      idx ++;
      return item;
    }

    // TODO: Next implement 2) remove() method
    public void remove() {
      throw new UnsupportedOperationException();
    }

  } // end of ToyBoxIterator

} // end of ToyBox<T>

public class ToyBoxIteratorTest {

  public static void showToysinBox(ToyBox<? extends Toy> b) {
    //      int size = b.getSize();
    //      for(int i=0; i < size; i++)
    //        System.out.println(b.get(i));
    for(Toy a : b) 
      System.out.println(a);
  }

  public static void main(String[] args) {
    ToyBox<Car> carBox = new ToyBox<Car>();
    Car t1 = new Car("Yaris", 1500);
    Car t2 = new Car("Corolla", 2500);
    carBox.add(t1);
    carBox.add(t2);
    showToysinBox(carBox);

    ToyBox<Bear> bearBox = new ToyBox<Bear>();
    Bear b1 = new Bear("Bear1", 1000);
    Bear b2 = new Bear("Bear2", 2000);
    bearBox.add(b1);
    bearBox.add(b2);
    showToysinBox(bearBox);
    /* It is OK till now */

    // Next, create ToyBox<Toy>
    ToyBox<Toy> toyBox = new ToyBox<Toy>();

    Car t3 = new Car("Tacoma", 3300);
    Bear b3 = new Bear("Bear3", 1200);

    toyBox.add(t3);
    toyBox.add(b3);

    showToysinBox(toyBox);
    /* It is still OK till now */

    // How about the next? Is it subtype?
    Car t4 = new Car("Prius", 4300);
    carBox.add(t4);

    ToyBox<? extends Toy> sometoyBox = carBox;
    System.out.println("After assigning the carBox into the \"sometoyBox\"...");
    showToysinBox(sometoyBox);
  }
}

class Toy {
  String name;
  int price;
  Toy(String n, int p) {
    name = n;
    price = p;
  }

  public String toString() {
    return new String("Name= " + name + ", price= " + price);
  }
}

class Car extends Toy {
  public Car(String n, int p) {
    super(n,p);
  }
}

class Bear extends Toy {
  public Bear(String n, int p) {
    super(n,p);
  }
}
