package packagetest;
import demopackage.*;
public class UsageDemoPackage {
  public static void main(String[] args) {
   ClassOne v1 = new ClassOne();
   ClassTwo v2 = new ClassTwo();
   v1.methodClassOne();
   v2.methodClassTwo();
  }
}