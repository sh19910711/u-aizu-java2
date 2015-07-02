import java.io.*;
import java.net.*;
import java.util.*;

public class FReaderClient {
  final int PORT = 8080;

  FReaderClient(final String filename) {
    try {
      Socket socket = new Socket("localhost", PORT);
      OutputStream os = socket.getOutputStream();
      DataOutputStream out = new DataOutputStream(os);
      out.writeUTF(filename + "\n");

      InputStream is = socket.getInputStream();
      BufferedReader buf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
      String line;
      while((line = buf.readLine()) != null) {
        System.out.println(line);
      }

      socket.close();
    } catch(Exception e) {
      System.out.println("Exception: " + e);
    }
  }

  public static void main(String[] args) {
    new FReaderClient(args[0]);
  }
}
