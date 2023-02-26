import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RegistryImpl implements Registry_itf{

    public Map<String, Integer> pageJaune;
    ArrayList<ClientPush_itf> clients = new ArrayList<>();
    @Override
    public void register(Accounting_itf client, Info_itf clientInfo) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(clientInfo.getHost());
        ClientPush_itf c = (ClientPush_itf) registry.lookup(clientInfo.getServiceName());
        clients.add(c);
        if (pageJaune == null)
            pageJaune = new HashMap<>();
        pageJaune.put(clientInfo.getName(), 20);
        client.numberOfCalls(20);

    }
}
