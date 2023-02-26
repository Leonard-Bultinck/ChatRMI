import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Info_itf extends Remote {
    public String getName() throws RemoteException;
    public String getHost() throws RemoteException;
    public String getServiceName() throws RemoteException;
}
