class CarRegistryQueue {
  private SingleLinkQueue<Car> queue = new SingleLinkQueue<Car>();
  private Object lock = new Object();

  // should be syncronized
  public void add(Car j) {  
    synchronized(lock) {
      queue.add(j);
    }
  }

  // should be syncronized
  public Car remove() throws InterruptedException {
    synchronized(lock) {
      return queue.remove();
    }
  }

  public Car[] toArray() {
    Car[] cars = new Car[queue.size()];
    return queue.toArray(cars);
  }
}
