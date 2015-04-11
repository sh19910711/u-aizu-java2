public class Car extends Vehicle {

  private Integer numberOfSeats;
  private Boolean airConditionOn;

  public Car(String modelName, String company, String owner, String engineType, Double tankSize, Double fuelConsumption, Integer numberOfSeats) {
    super(modelName, company, owner, engineType, tankSize, fuelConsumption);
    this.numberOfSeats = numberOfSeats;
    this.airConditionOn = false;
  }

  public Double costFor100Km(PetroleumPrice p) {
    return p.getGasolineCost() * 100.0 / getFuelConsumption();
  }

  public void setAirConON() {
    airConditionOn = true;
  }

  public void setAirConOFF() {
    airConditionOn = false;
  }

  public String toString() {
    return super.toString()
      + String.format(", NumberOfSeat: %d", numberOfSeats);
  }

  protected Double getFuelConsumption() {
    if ( airConditionOn ) {
      return fuelConsumption * 0.9;
    } else {
      return fuelConsumption;
    }
  }

}
