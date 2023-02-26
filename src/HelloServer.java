import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.HashMap;
import java.util.Map;

public class HelloServer {
    public static void main(String[] args){
        try {
            // Create a Hello remote Object
            HelloImpl h = new HelloImpl("Hello World ! ");
            Hello h_stub = (Hello) UnicastRemoteObject.exportObject(h,0);

            // Register the remote object in RMI registry with a given identifier
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("HelloService", h_stub);

            RegistryImpl h3 = new RegistryImpl();
            Registry_itf h3_stub = (Registry_itf) UnicastRemoteObject.exportObject(h3,0);

            Registry registry3 = LocateRegistry.getRegistry();
            registry3.bind("RegistryService", h3_stub);


            Hello2Impl h2 = new Hello2Impl("Hello World ! ",h3);
            Hello2 h2_stub = (Hello2) UnicastRemoteObject.exportObject(h2,0);

            Registry registry2 = LocateRegistry.getRegistry();
            registry2.bind("Hello2Service", h2_stub);


            System.out.println("Server ready");
        } catch (Exception e){
            System.err.println("Error on server :" + e);
            e.printStackTrace();
        }
    }

}
