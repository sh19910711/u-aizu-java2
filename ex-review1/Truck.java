public class Truck extends Vehicle {

  private Integer numberOfSeats;
  private Boolean airConditionOn;
  private Integer power;

  public Truck(String modelName, String company, String owner, String engineType, Double tankSize, Double fuelConsumption, Integer numberOfSeats, Integer power) {
    super(modelName, company, owner, engineType, tankSize, fuelConsumption);
    this.numberOfSeats = numberOfSeats;
    this.power = power;
    this.airConditionOn = false;
  }

  public Double costFor100Km(PetroleumPrice p) {
    if ( engineType == "Gasoline" || engineType == "Hybrid" ) {
      return p.getGasolineCost() * 100.0 / getFuelConsumption();
    } else {
      return p.getDieselCost() * 100.0 / getFuelConsumption();
    }
  }

  public void setAirConON() {
    airConditionOn = true;
  }

  public void setAirConOFF() {
    airConditionOn = false;
  }

  public String toString() {
    return super.toString()
      + String.format(", NumberOfSeat: %d, HorsePower: %d", numberOfSeats, power);
  }

  protected Double getFuelConsumption() {
    if ( airConditionOn ) {
      return fuelConsumption * 0.8;
    } else {
      return fuelConsumption;
    }
  }

}
