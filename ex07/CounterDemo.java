// Task 2: Thread-safe counter
//
// Modify your code from the first question and write a thread-safe counter.
// Please save your code in the files Counter.java and CounterDemo.java.
// Verify that the value of the counter at the end is the expected value of two millions.

public class CounterDemo {
  public Counter counter = new Counter();

  CounterDemo() {
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
    private Counter counter;

    public void run() {
      for ( int i = 0; i < 1000000; ++ i ) {
        counter.increment();
      }
    }

    Loop(Counter counter) {
      this.counter = counter;
    }
  }

  public static void main(String[] args) {
    new CounterDemo();
  }
}

