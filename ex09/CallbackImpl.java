import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;

public class CallbackImpl extends UnicastRemoteObject implements Callback {

  public CallbackImpl() throws RemoteException {
    super();
  }

  public String greeting(String lang) throws RemoteException {
    CallbackServer server = new CallbackServer();
    return server.sayHello(this, lang);
  }
  public String speakJapanese() {
    return new String("Konnichiwa!");
  }
  public String speakEnglish() {
    return new String("How are you!");
  }

  public String thanks(String lang) throws RemoteException {
    CallbackServer server = new CallbackServer();
    return server.sayThanks(this, lang);
  }
  public String thanksJapanese() {
    return new String("Arigatou gozaimasu!");
  }
  public String thanksEnglish() {
    return new String("Thank you!");
  }

  public static void main(String args[]) { 

    // Create and install a security manager 
    if (System.getSecurityManager() == null) { 
      System.setSecurityManager(new RMISecurityManager()); 
    } 
    try { 
      CallbackImpl obj = new CallbackImpl(); 
      // Bind this object instance to the name "MyCallbackServer" 
      Naming.rebind("MyCallbackServer", obj); 
      System.out.println("MyCallbackServer bound in registry"); 
    } catch (Exception e) { 
      System.out.println("CallbackImpl err: " + e.getMessage()); 
      e.printStackTrace(); 
    } 
  } 
}
