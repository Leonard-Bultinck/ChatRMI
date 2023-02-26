import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientPush_itf extends Remote {
    public void push(String m) throws RemoteException;
}
