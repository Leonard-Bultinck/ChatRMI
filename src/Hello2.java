import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello2 extends Remote {
    public String sayHello(Info_itf client, Accounting_itf type) throws RemoteException;
    public String sayHello(Info_itf client, Accounting_itf type,StringRMI_itf message) throws RemoteException;



}