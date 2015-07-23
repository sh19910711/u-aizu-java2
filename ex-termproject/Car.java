class Car extends MotorVehicle {
  private int numberOfSeats = 4;

  public Car() {}

  public Car(int hp, String lpn, String make, String mn, String on, EngineType et) {
  }

  public Car(int hp, int ns, String lpn, String make, String mn, String on, EngineType et) {
  }

  public void setNumberofSeats(int ns) {
  }

  public int getNumberofSeats() {
    return -1; // TODO
  }

  public String toString() {
    return "null-car"; // TODO
  }
}
