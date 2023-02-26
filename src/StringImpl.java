import java.rmi.RemoteException;

public class StringImpl implements StringRMI_itf{
    private String message;

    public StringImpl(String msg){
        message = msg;
    }

    public void putMessage(String message){
        this.message = message;
    }

    public String getMessage() throws RemoteException{
        return message;
    }
}
