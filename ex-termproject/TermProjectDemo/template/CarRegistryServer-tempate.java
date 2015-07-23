import java.util.Random;
import java.lang.*;

class CarRegistryServer {
  private final CarRegistryQueue registry; 

  public CarRegistryServer() {
    registry = new CarRegistryQueue();

  }

 private void register (Car carobj) {
   registry.add(carobj);
 }

 public void getback (Car carobj) {
   registry.add(carobj);
 }

 public Car request (EngineType e, int number)
   throws InterruptedException
 {


 }

}
