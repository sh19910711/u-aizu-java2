import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject
implements Hello {

  public HelloImpl() throws RemoteException {
    super();
  }

  public String sayHello() {
    return  "Hi! I am in localhost server and using port 1099!";
  }

  public static void main(String args[]) { 
    // Create and install a security manager 
    if (System.getSecurityManager() == null) { 
      System.setSecurityManager(new RMISecurityManager()); 
    } 
    try { 
      HelloImpl obj = new HelloImpl(); 
      // Bind this object instance to the name "HelloServer" 
      // RMI uses 1099 as a default port
      //          Naming.rebind("//lecsv3:1234/HelloServer", obj); 
      Naming.rebind("//localhost:1099/HelloServer", obj); 
      //Naming.rebind("HelloServer", obj); 
      System.out.println("HelloServer bound in registry"); 
    } catch (Exception e) { 
      System.out.println("HelloImpl err: " + e.getMessage()); 
      e.printStackTrace(); 
    } 
  } 
}
