import java.rmi.RemoteException;

public class ClientImpl implements Info_itf, Accounting_itf {
    int nb;
    String host;
    String service;
    String name;

    public ClientImpl(String name, String host, String service){
        this.host = host;
        this.service = service;
        this.name = name;
    }

    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public String getHost() throws RemoteException {
        return host;
    }

    @Override
    public String getServiceName() throws RemoteException {
        return service;
    }

    public void numberOfCalls(int number) throws RemoteException {
        nb = number;
    }

    public int getNumberOfCalls() throws RemoteException {
        return nb;
    }
}
