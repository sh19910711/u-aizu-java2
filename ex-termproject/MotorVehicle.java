public class MotorVehicle extends Vehicle {
  public EngineType engineType;
  private int horsePower;

  public MotorVehicle() {}

  public MotorVehicle(int hp, String lpn, String make, String mn, String on, EngineType et) {
    this.engineType = et;
    this.horsePower = hp;
    // super(lpn, make, mn, on);
  } 

  public int getHorsePower() {
    return -1; // TODO
  }

  public EngineType getEngineType() {
    return engineType;
  }

  public String toString() {
    return "null"; // TODO
  }
}
