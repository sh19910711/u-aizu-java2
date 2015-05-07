class Vehicle {
  public static final int GAS_ENGINE = 1;
  public static final int DIESEL_ENGINE = 2;

  public final int engineType;
  private int horsePower;
  public final int numberOfWheels;

  private String licensePlateNumber;
  public final String make;
  public final String modelName;
  private String ownerName;

  public Vehicle  (int hp, int nw, String lpn, String make, String mn, String on, int et) {
    engineType = et;
    horsePower = hp;
    numberOfWheels = nw;
    licensePlateNumber = lpn;
    this.make = make;
    modelName = mn;
    ownerName = on;
  }

  public String getLicensePlateNumber() {
    return licensePlateNumber;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public String toString() {
    return new StringBuffer(128).append("Owner: ").append(ownerName).append(",LicensePlateNumber: ").append(licensePlateNumber).append(",Make: ").append(make).toString();
  }

  public void setLicensePlateNumber(String new_number) {

   licensePlateNumber = new_number;
  }

  public void setOwnerName(String new_name) {
    ownerName = new_name;
  }
}
