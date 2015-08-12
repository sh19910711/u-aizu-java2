class Car extends MotorVehicle {
  private int numberOfSeats = 4;

  public Car() {}
  
  public Car(int hp, String lpn, String make, String mn, String on, EngineType et) {
    // super(hp, lpn, make, mn, on, et);
  }

  public Car(int hp, int ns, String lpn, String make, String mn, String on, EngineType et) {
    setNumberofSeats(ns);
    // super(hp, lpn, make, mn, on, et);
  }

  public void setNumberofSeats(int ns) {
    numberOfSeats = ns;
  }

  public int getNumberofSeats() {
    return numberOfSeats;
  }

  public String toString() {
    return "make = " + make;
  }
}
