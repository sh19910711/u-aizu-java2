import java.util.Random;
import java.lang.*;
import java.util.ArrayList;

class CarRegistryServer {
  private final CarRegistryQueue registry; 

  public CarRegistryServer() {
    registry = new CarRegistryQueue();
    register(new Car(250, 5, "1234A", "Toyota","Corolla","Windom Toyota", EngineType.GAS_ENGINE));
    register(new Car(150, 9, "1432B", "Honda","Stream", "Sunsuke Honda", EngineType.DIESEL_ENGINE));
    register(new Car(170, 4, "1212A", "Toyota","Avalon","Yusuke Toyota", EngineType.GAS_ENGINE));
    register(new Car(200, 6, "3210B", "Toyota","Camry", "Yuu Toyota", EngineType.GAS_ENGINE));
    register(new Car(190, 7, "1111A", "Honda","Accord", "Daisuke Honda", EngineType.DIESEL_ENGINE));
    register(new Car(200, 5, "1111B", "Honda","Inspire", "Yuuich Honda", EngineType.GAS_ENGINE));
  }

  private void register(Car carobj) {
    registry.add(carobj);
  }

  public void getback(Car carobj) {
    registry.add(carobj);
  }

  public Car request(EngineType e, int number) throws InterruptedException {
    for (Car c : registry.toArray()) {
      System.out.println(c.getEngineType() + ", " + e + ", " + c.getNumberofSeats() + ", " + number);
      if (c.getEngineType() == e && c.getNumberofSeats() >= number) {
        return c;
      }
    }
    return null;
  }
}
