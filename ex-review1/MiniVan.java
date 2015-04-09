public class MiniVan extends Vehicle {

  private Integer numberOfSeats;
  private Boolean airConditionOn;
  private Boolean hasAutoDoor;

  public MiniVan(String modelName, String company, String owner, String engineType, Double tankSize, Double fuelConsumption, Integer numberOfSeats, Boolean hasAutoDoor) {
    super(modelName, company, owner, engineType, tankSize, fuelConsumption);
    this.numberOfSeats = numberOfSeats;
    this.hasAutoDoor = hasAutoDoor;
  }

  public Integer costFor100Km(PetroleumPrice p) {
    return -1;
  }

  public void setAirConON() {
    airConditionOn = true;
  }

  public void setAirConOFF() {
    airConditionOn = false;
  }

}
