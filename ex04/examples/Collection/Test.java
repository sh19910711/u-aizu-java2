class ArrayTest {
  int arr;
  public ArrayTest() {
    arr = 100;
    System.out.println("ArrayTest constructor...");
  }
  
  public int getData() {
    return arr;
  }
}

public class Test {
  public static void main(String[] args) {
//  ArrayTest[] myArr = new ArrayTest[10];
    ArrayTest[] myArr;
    int i;
    for(i=0; i<10; i++) {
      myArr[i] = new ArrayTest();
    }
    for(i=0; i<10; i++) {
      System.out.println("Array Test = " + myArr[i].getData());
    }
  }
}
