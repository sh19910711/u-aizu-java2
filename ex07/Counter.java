public class Counter {
  private Object lock = new Object();
  private int count;

  public void increment() {
    synchronized(lock) {
      count++;
    }
  }

  public int get() {
    return count;
  }
}
