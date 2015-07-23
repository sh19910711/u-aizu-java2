class CarRegistryQueue {
  private SingleLinkQueue<Car> queue = new SingleLinkQueue<Car>();

  // should be syncronized
  public void add(Car j) {  
  }

  // should be syncronized
  public Car remove() throws InterruptedException {
    return null; // TODO
  }
}
