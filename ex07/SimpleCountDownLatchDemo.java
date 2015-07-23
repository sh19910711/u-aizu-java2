import java.util.concurrent.ThreadLocalRandom;


public class SimpleCountDownLatchDemo {
  public static void main(String[] args) {
    int num_tasks = 3;
    SimpleCountDownLatch latch = new SimpleCountDownLatch(num_tasks);
    Waiter waiter = new Waiter(latch);
    Task task1 = new Task(latch);
    Task task2 = new Task(latch);
    Task task3 = new Task(latch);

    Thread w = new Thread(waiter);
    w.start();

    Thread t1 = new Thread(task1);
    t1.start();
    Thread t2 = new Thread(task2);
    t2.start();
    Thread t3 = new Thread(task3);
    t3.start();

  }
}


class Waiter implements Runnable {
  private SimpleCountDownLatch latch;

  public Waiter(SimpleCountDownLatch latch) {
    this.latch = latch;
  }

  public void run() {
    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("All tasks done");
    System.out.println("Waiter released");
  }
}


class Task implements Runnable {
  private SimpleCountDownLatch latch;

  public Task(SimpleCountDownLatch latch) {
    this.latch = latch;
  }

  public void run() {
    try {
      // Simulate the time taken by some activity
      ThreadLocalRandom rng = ThreadLocalRandom.current();
      long sleep_time = (long)((rng.nextDouble() + 1.0) * 5000);
      Thread.sleep(sleep_time);

      latch.countDown();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
