public abstract class Vehicle {

  protected String modelName;
  protected String company;
  protected String owner;
  protected String engineType;
  protected Double tankSize;
  protected Double fuelConsumption;

  public Vehicle(String modelName, String company, String owner, String engineType, Double tankSize, Double fuelConsumption) {
    this.modelName = modelName;
    this.company = company;
    this.owner = owner;
    this.engineType = engineType;
    this.tankSize = tankSize;
    this.fuelConsumption = fuelConsumption;
  }

  public String toString() {
    return "TODO";
  }

  public Integer movableDistance() {
    return -1;
  }

  abstract public Integer costFor100Km(PetroleumPrice p);
  abstract public void setAirConON();
  abstract public void setAirConOFF();

}