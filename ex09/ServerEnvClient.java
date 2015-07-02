import java.rmi.Naming;
import java.rmi.RemoteException;

public class ServerEnvClient {
  public static void main(String args[]) {
    ServerEnv obj = null;
    String remoteHost = null;
    String remoteOS = null;

    try {
      obj = (ServerEnv)Naming.lookup("//localhost:1099/ServerEnvServer");
      remoteHost = obj.getHostName();
      remoteOS = obj.getOS();
    } catch (Exception e) {
      System.out.println("ServerClient error: " + e.getMessage());
      e.printStackTrace();
    }

    System.out.println(
        String.format("Server Env: OS of %s is %s\n", remoteHost, remoteOS));
  }
}
