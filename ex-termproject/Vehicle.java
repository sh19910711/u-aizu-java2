public class Vehicle {
  private String licensePlateNumber;
  public String make;
  public String modelName;
  private String ownerName;

  public Vehicle() {}

  public Vehicle(String lpn, String make, String mn, String on) {
  }

  public String getLicensePlateNumber() {
    return "null-license"; // TODO
  }

  public String getOwnerName() {
    return "null-owner"; // TODO
  }

  public void setLicensePlateNumber(String new_number) {
  }

  public void setOwnerName(String new_name) {
  }

  public String toString() {
    return "vehicle";
  }
}
