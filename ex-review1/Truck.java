public class Truck extends Vehicle {

  private Integer numberOfSeats;
  private Boolean airConditionOn;
  private Integer power;

  public Truck(String modelName, String company, String owner, String engineType, Double tankSize, Double fuelConsumption, Integer numberOfSeats, Integer power) {
    super(modelName, company, owner, engineType, tankSize, fuelConsumption);
    this.numberOfSeats = numberOfSeats;
    this.power = power;
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

  public String toString() {
    return super.toString()
      + String.format(", NumberOfSeat: %d, HorsePower: %d", numberOfSeats, power);
  }

}
