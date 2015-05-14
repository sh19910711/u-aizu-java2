import java.util.*;

class Cage<T> /* Insert code for being iterable class */ {

    private Vector<T> v = new Vector<T>();          

    public void add(T t) {
        v.add(t);
    }

    public T get(int i) {
        return v.get(i);
    }

    public int getSize() {
        return v.size();
    }

    /* write code for iterator method -- it returns an object of the MyIterator */
    // ...................................

  // MyIterator class -- inner class
  private class MyIterator /* complete here to implment Iterator interface */ {
      int idx; // counter to point current posion of an element of the vector for iterating

      // Constructor
      public MyIterator() {
        idx = 0;
      }

      // Method to test whether more elements are available
      public boolean hasNext() {
         // complete hasNext() method 
         // ...................................
      }

      // Next implement 1) next() method and 2) remove() method
      // ...................................

  } // end of MyIterator

} // end of Cage<T>

public class CageIteratorTest {

    public static void showAnimalsinCage(Cage<? extends Animal> somecage) {
      /*** old version
       int size = somecage.getSize();
       for(int i=0; i < size; i++) 
         System.out.println(somecage.get(i));
      ***/
       for(Animal a : somecage) 
         System.out.println(a);
    }

    public static void main(String[] args) {

      Cage<Lion> lioncage = new Cage<Lion>();
      Lion l1 = new Lion("LionKing1", 20);
      Lion l2 = new Lion("LionKing2", 30);
      lioncage.add(l1);
      lioncage.add(l2);
      showAnimalsinCage(lioncage);

      Cage<Butterfly> butterflycage = new Cage<Butterfly>();
      Butterfly b1 = new Butterfly("Butterfly1", 1);
      Butterfly b2 = new Butterfly("Butterfly2", 2);
      butterflycage.add(b1);
      butterflycage.add(b2);
      showAnimalsinCage(butterflycage);
      /* It is OK till now */

      // Next, create Cage<Animal>
      Cage<Animal> animalcage = new Cage<Animal>();

      Lion l3 = new Lion("LionKing3", 40);
      Butterfly b3 = new Butterfly("Butterfly3", 3);

      animalcage.add(l3);
      animalcage.add(b3);

      showAnimalsinCage(animalcage);
      /* It is still OK till now */

      // How about the next? Is it subtype?
      Cage<? extends Animal> someanimalcage = new Cage<Animal>();
      Lion l4 = new Lion("LionKing4", 50);
      lioncage.add(l4);
      someanimalcage = lioncage;
      System.out.println("After assigning the lioncage into the \"someanimalcage\"...");
      showAnimalsinCage(someanimalcage);
    }
}

class Animal {
   String name;
   int age;
    Animal(String n, int a) {
       name = n;
       age = a;
    }

    public String toString() {
      return new String("Name= " + name + ", age= " + age);
    }
}

class Lion extends Animal {
   public Lion(String n, int a) {
     super(n,a);
   }
}

class Butterfly extends Animal {
   public Butterfly(String n, int a) {
     super(n,a);
   }

}