import java.io.*;
import java.net.*;
import java.util.*;

public class FReaderClient {
  FReaderClient(final String filename) {
    try {
      // Connect
      Socket socket = new Socket(Common.HOST, Common.PORT);
      OutputStream os = socket.getOutputStream();

      // Send request
      DataOutputStream out = new DataOutputStream(os);
      out.writeUTF(filename);
      out.flush();

      // Get file length
      InputStream is = socket.getInputStream();
      DataInputStream in = new DataInputStream(is);
      int length = in.readInt();
      System.out.println("File Size = " + length);

      // Get file content
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
