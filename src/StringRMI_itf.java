import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringRMI_itf extends Remote {
    public String getMessage() throws RemoteException;
}
