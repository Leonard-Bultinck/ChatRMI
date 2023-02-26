import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.Remote;

public interface Registry_itf extends Remote {
    public void register( Accounting_itf client, Info_itf serviceName) throws RemoteException, NotBoundException;
 }
