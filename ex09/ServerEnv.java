import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerEnv extends Remote {
  String getHostName() throws RemoteException;
  String getOS() throws RemoteException;
}
