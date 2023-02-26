import java.rmi.RemoteException;

public class ClientPushImpl implements ClientPush_itf {
    @Override
    public void push(String m) throws RemoteException {
        System.out.println(m);
    }
}
