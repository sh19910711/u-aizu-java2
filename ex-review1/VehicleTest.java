public class VehicleTest {

  public static void describe(Vehicle v) {
    System.out.println(v);
  }

  public static void main(String[] args) {
    Vehicle vehicles[] = {
      new Car("Camley", "Toyota", "Suzuki", "Gasoline", 70., 15.15, 5),
      new Car("Aqua", "Toyota", "Nakajima", "Hybrid", 36., 40.0, 5),
      new MiniVan("Sienna", "Toyota", "Tanaka", "Gasoline", 75.,  9.0, 8, true),
      new MiniVan("Odyssey", "Honda", "Kikuchi", "Diesel", 56., 11.0, 8, false),
      new MiniVan("Presage", "Nissan", "Shirotora", "Gasoline", 60., 7.0, 7, false),
      new Truck("Tundra", "Toyota", "Sugai", "Diesel", 100., 6.76, 5, 310),
      new Truck("Ridgeline", "Honda", "Watanabe", "Diesel", 83.279, 7.23, 5, 250)
    };

    PetroleumPrice priceInfo = new PetroleumPrice(143., 99.4);

    for(Vehicle v: vehicles) {
      describe(v);
      System.out.println("Movable distance: " + v.movableDistance() + " Km");
      System.out.println("Cost for 100 Km: " + v.costFor100Km(priceInfo) + " Yen");
      System.out.println(); 
    }
    System.out.println(); 
    System.out.println("After Aircondition is ON\n");
    for(Vehicle v: vehicles) {
      v.setAirConON();
      describe(v);
      System.out.println("Movable distance: " + v.movableDistance() + " Km");
      System.out.println("Cost for 100 Km: " + v.costFor100Km(priceInfo) + " Yen");
      System.out.println(); 
    }

  }  // end of main 
}
