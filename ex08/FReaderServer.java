import java.io.*;
import java.net.*;
import java.util.*;

public class FReaderServer {
  FReaderServer() {
    // providing contents
    String[] filenames = {
      "Hello.java",
      "Common.java",
    };

    Set<String> files = new HashSet<String>();
    for (String filename : filenames) {
      files.add(filename);
      File f = new File(filename);
      System.out.println("Providing contents of the file (" + filename + "), Size = " + f.length());
    }

    try {
      ServerSocket serverSocket = new ServerSocket(Common.PORT);
      while (true) {
        Socket socket = serverSocket.accept();

        // Input Requested Filename
        InputStream is = socket.getInputStream();
        DataInputStream in = new DataInputStream(is);
        String req = in.readUTF().trim();

        // Output Requested File
        OutputStream os = socket.getOutputStream();
        DataOutputStream out = new DataOutputStream(os);
        out.flush();

        if (files.contains(req)) {
          // send file size
          File file = new File(req);
          int len = (int)file.length();
          out.writeInt(len);

          // send file content
          FileInputStream fis = new FileInputStream(req);
          byte[] bytes = new byte[len];
          int cnt;
          while ((cnt = fis.read(bytes)) > 0) {
            out.write(bytes, 0, cnt);
          }
        } else {
          out.writeChars("not found\n");
        }

        socket.close();
      }
    } catch(Exception e) {
      System.out.println("Exception: " + e);
    }
  }

  public static void main(String[] args) {
    new FReaderServer();
  }
}
