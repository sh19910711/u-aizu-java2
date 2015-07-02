public class Common {
  static final String HOST = "localhost";
  static final int PORT = 8080;

  static void printBytes(String s) {
    for (Byte b : s.getBytes()) {
      System.out.print(b + ", ");
    }
    System.out.println();
  }
}
