import java.text.DecimalFormat;

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
    DecimalFormat df = new DecimalFormat("###.0########################################");
    return String.format("ModelName: %s, Company: %s, Owner: %s, EngineType: %s, TankSize: %s, FuelConsumption: %s",
        modelName, company, owner, engineType, df.format(tankSize), df.format(getFuelConsumption()));
  }

  public Double movableDistance() {
    return tankSize * getFuelConsumption();
  }

  abstract public Double costFor100Km(PetroleumPrice p);
  abstract public void setAirConON();
  abstract public void setAirConOFF();

  protected Double getFuelConsumption() {
    return fuelConsumption;
  }

}
