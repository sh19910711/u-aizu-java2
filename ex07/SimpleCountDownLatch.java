// Task 3: Count-down latch
//
// - The goal of this task is to implement a class SimpleCountDownLatch,
//   defined as follows:
// 1. An instance of SimpleCountDownLatch is initialized with a given count (an integer).
// - It has two methods countDown() and await().
// 2. The method countDown() decrements the variable count.
// 3. The method await() blocks until count is zero.
// 4. Save your implementation in the file named SimpleCountDownLatch.java.
//    You can use the following code for testing it.
// 
// Such type of objects (Count-down latches) are used as a synchronization tool.
// They allow one or more threads to wait until tasks performed in other threads completes.

public class SimpleCountDownLatch {
  private int tasks;

  public SimpleCountDownLatch(int tasks) {
    this.tasks = tasks;
  }

  synchronized public void countDown() throws InterruptedException {
    System.out.println("Latch: count down tasks => " + tasks);
    tasks --;
    notifyAll();
  }

  synchronized public void await() throws InterruptedException {
    System.out.println("Latch: before wait");
    while ( tasks > 0 ) {
      try {
        wait();
      } catch(InterruptedException ie) {
        ie.printStackTrace();
        System.exit(0);
      }
    }
    System.out.println("Latch: after wait");
  }
}
