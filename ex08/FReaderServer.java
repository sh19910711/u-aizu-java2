import java.io.*;
import java.net.*;
import java.util.*;

public class FReaderServer {
  final int PORT = 8080;

  FReaderServer() {
    String[] filenames = {"Hello.java"};
    Set<String> files = new HashSet<String>();
    for (String filename : filenames) {
      files.add(filename);
      File f = new File(filename);
      System.out.println("Providing contents of the file (" + filename + "), Size = " + f.length());
    }

    try {
      ServerSocket serverSocket = new ServerSocket(PORT);
      while (true) {
        Socket socket = serverSocket.accept();

        // Input Requested Filename
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String req = dis.readLine();

        // Output Requested File
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        System.out.println("req: " + req);
        System.out.println("req = '" + req + "' (" + files.contains(req) + ")");
        System.out.println("req = 'Hello.java' (" + files.contains("Hello.java") + ")");
        if (files.contains(req)) {
          DataInputStream fileInput = new DataInputStream(new FileInputStream(req));
          String line;
          while ((line = fileInput.readLine()) != null) {
            dos.writeChars(line);
            dos.writeChars("\n");
          }
        } else {
          dos.writeChars("not found\n");
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
