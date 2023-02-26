import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class HelloClient {
    public static void main(String[] args) {
        try {
            if (args.length < 2){
                System.out.println("Usage: java HelloClient <rmiregistry host> <name>");
                return;
            }
            String host = args[0];
            String name = args[1];

            //Add Push function
            ClientPushImpl c = new ClientPushImpl();
            ClientPush_itf c_stub = (ClientPush_itf) UnicastRemoteObject.exportObject(c,0);

            Registry registryPush = LocateRegistry.getRegistry();
            registryPush.bind(name, c_stub);

            //Get remote object reference
            Registry registry = LocateRegistry.getRegistry(host);
            Registry registry1 = LocateRegistry.getRegistry(host);

            Hello2 h = (Hello2) registry.lookup("Hello2Service");
            Registry_itf r = (Registry_itf) registry1.lookup("RegistryService");

            //Remote method invocation
            Info_itf i = new ClientImpl(name,host,name);
            Accounting_itf a = (Accounting_itf) i;

            r.register((Accounting_itf) UnicastRemoteObject.exportObject(a,0),i);
            String res = h.sayHello(i, a);
            //Sending my message
            Scanner input = new Scanner(System.in);
            System.out.println(res);
            StringRMI_itf line = new StringImpl(input.nextLine());
            h.sayHello(i,a,(StringRMI_itf) UnicastRemoteObject.exportObject(line,0));

            while (true) {
                ((StringImpl) line).putMessage(input.nextLine());
                if (line.equals("bye")) {break;}
                res = h.sayHello(i,a,line);
                System.out.println(res);
            }

        } catch (Exception e) {
            System.err.println("Error on client: " +e);
        }
    }

}
