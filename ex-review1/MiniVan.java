public class MiniVan extends Vehicle {

  private Integer numberOfSeats;
  private Boolean airConditionOn;
  private Boolean hasAutoDoor;

  public MiniVan(String modelName, String company, String owner, String engineType, Double tankSize, Double fuelConsumption, Integer numberOfSeats, Boolean hasAutoDoor) {
    super(modelName, company, owner, engineType, tankSize, fuelConsumption);
    this.numberOfSeats = numberOfSeats;
    this.hasAutoDoor = hasAutoDoor;
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
      + String.format(", NumberOfSeat: %d, HasAutoDoor: %s", numberOfSeats, booleanToString(hasAutoDoor));
  }

  private String booleanToString(Boolean b) {
    return b ? "true" : "false";
  }

  protected Double getFuelConsumption() {
    if ( airConditionOn ) {
      return fuelConsumption * 0.8;
    } else {
      return fuelConsumption;
    }
  }

}
