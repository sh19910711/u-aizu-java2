import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.net.InetAddress;

public class ServerEnvImpl
extends UnicastRemoteObject
implements ServerEnv {

  public ServerEnvImpl() throws RemoteException {
    super();
  }

  public String getHostName() {
    String hostName = null;
    try {
      hostName = InetAddress.getLocalHost().getHostName();
    } catch(Exception e) {
      e.printStackTrace();
    }
    return hostName;
  }

  public String getOS() {
    return System.getProperty("os.name");
  }

  public static void main(String args[]) {
    if (System.getSecurityManager() == null) {
      System.setSecurityManager(new RMISecurityManager());
    }

    try {
      ServerEnvImpl obj = new ServerEnvImpl();
      Naming.rebind("//localhost:1099/ServerEnvServer", obj);
      System.out.println("ServerEnvServer bound in registry");
    } catch (Exception e) {
      System.out.println("ServerEnvImpl: error: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
