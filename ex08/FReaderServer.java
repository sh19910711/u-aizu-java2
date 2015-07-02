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
        DataInputStream in = new DataInputStream(is);
        String req = in.readUTF().trim();

        // Output Requested File
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        if (files.contains(req)) {
          BufferedReader bufReader = new BufferedReader(
              new InputStreamReader(new FileInputStream(req), "UTF-8"));
          String line;
          while ((line = bufReader.readLine()) != null) {
            dos.writeUTF(line);
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
