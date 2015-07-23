public class MotorVehicle extends Vehicle {
  public EngineType engineType;
  private int horsePower;

  public MotorVehicle() {
  }

  public MotorVehicle(int hp, String lpn, String make, String mn, String on, EngineType et) {
    this.engineType = et;
  } 

  public int getHorsePower() {
    return -1; // TODO
  }

  public EngineType getEngineType() {
    return null; // TODO
  }

  public String toString() {
    return "null"; // TODO
  }
}
