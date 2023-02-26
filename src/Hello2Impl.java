import java.io.*;
import java.rmi.*;


public class Hello2Impl implements Hello2{

    private String message;
    private RegistryImpl reg;

    FileInputStream historyI;

    FileOutputStream historyO;
    String hist;

    File fic;
    public Hello2Impl(String s,RegistryImpl registry){
        message = s;
        reg = registry;
        fic = new File("history.txt");
        hist = "";
        try {
            historyI = new FileInputStream(fic);
            historyO = new FileOutputStream(fic, true);
        }catch( Exception e ){System.out.println(e);}
    }


    @Override
    public String sayHello(Info_itf client, Accounting_itf type) throws RemoteException {
        if (type.getNumberOfCalls() >= 1) {
            type.numberOfCalls(type.getNumberOfCalls() - 1);
            String tmp;
            BufferedReader br = new BufferedReader(new InputStreamReader(historyI));
            try {
                while ((tmp = br.readLine()) != null) {
                    hist += tmp+"\n";
                }
            }catch(Exception e){System.out.println(e);}
            for (ClientPush_itf c : reg.clients)

                c.push(client.getName() + " enter the room");
            return hist + "\n -- You are connected";
        }
        return client.getName() + "(" +type.getNumberOfCalls() +") : " +"Plus de message";
    }
    public String sayHello(Info_itf client, Accounting_itf type, StringRMI_itf message) throws RemoteException {
        if (type.getNumberOfCalls() >= 1) {
            type.numberOfCalls(type.getNumberOfCalls() - 1);
            String s = client.getName() + "(" +type.getNumberOfCalls() + ") : " + message.getMessage();
            String s1 = s+"\n";
            try {
                historyO.write(s1.getBytes());
            }catch(Exception e ){System.out.println(e);}
            for (ClientPush_itf c : reg.clients)
                c.push(s);
                return " -- send";
        }
        return client.getName() + "(" +type.getNumberOfCalls() +") : " +"Plus de message";
    }

}
