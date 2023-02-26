import java.rmi.RemoteException;
import java.rmi.Remote;

public interface Accounting_itf extends Remote {

    public void numberOfCalls(int number) throws RemoteException;
    public int getNumberOfCalls() throws RemoteException;

}
