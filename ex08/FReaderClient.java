import java.io.*;
import java.net.*;
import java.util.*;

public class FReaderClient {
  FReaderClient(final String filename) {
    try {
      Socket socket = new Socket(Common.HOST, Common.PORT);
      OutputStream os = socket.getOutputStream();
      DataOutputStream out = new DataOutputStream(os);
      out.writeUTF(filename);
      out.flush();

      InputStream is = socket.getInputStream();
      DataInputStream in = new DataInputStream(is);
      int length = in.readInt();
      System.out.println("File Size = " + length);

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
