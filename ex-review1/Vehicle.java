abstract class Vehicle {

  public String modelName;
  public String company;
  public String owner;
  public String engineType;
  public Integer tankSize;
  public Integer fuelConsumption;

  String toString() {
    return "TODO";
  }

  Integer movableDistance() {
    return -1;
  }

  abstract Integer costFor100Km();
  abstract void setAirConON();
  abstract void setAirConOFF();

}
