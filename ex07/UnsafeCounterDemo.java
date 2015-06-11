// Taks 1: Mutual exclusion
// 
// - Consider the following code that implements a shared counter.
// 1. Write a program UnsafeCounterDemo where two threads increment one million times
//    each a unique shared instance of UnsafeCounter.
// 2. Write the final value of the counter on the standard output stream.
// 3. Save your program in a file named UnsafeCounterDemo.java.
// 
// The expected result of the program is: two millions.
// * However, it is unlikely that you will obtain this result in practice.
// Why is it that the observed behavior is different than the expected one?
// * Please write your answer in a file named
//   UnsafeCounterDemo.txt.

public class UnsafeCounterDemo {
  public UnsafeCounter counter = new UnsafeCounter();

  UnsafeCounterDemo() {
    // create threads
    Thread t1 = new Loop(counter);
    Thread t2 = new Loop(counter);

    // start threads
    t1.start();
    t2.start();

    // wait threads
    try {
      t1.join();
      t2.join();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // show output
    System.out.println("count: " + counter.get() + " equals 2000000?");
  }

  class Loop extends Thread {
    private UnsafeCounter counter;

    public void run() {
      for ( int i = 0; i < 1000000; ++ i ) {
        counter.increment();
      }
    }

    Loop(UnsafeCounter counter) {
      this.counter = counter;
    }
  }

  public static void main(String[] args) {
    new UnsafeCounterDemo();
  }
}

