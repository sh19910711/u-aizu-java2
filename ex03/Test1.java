public class Test1 {

  private static class Point {
    public String toString() {
      return "Point";
    }
  }

  public static void main(String[] args) {
    Object p = new Point();
    System.out.println((String)p);
    System.out.println("Hello");
  }

}
