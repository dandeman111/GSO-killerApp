package Rmi.pushpull;

import Rmi.MatchFinder;
import fontyspublisher.RemotePublisher;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by dande on 15-6-2017.
 */
public class RulesServer {
    private static MatchFinder matchFinder;
    private static Registry registry;

    private static final int portNumber = 1100;
    private static final String bindingName = "RulesServer";

    public static void main(String[] args) throws RemoteException {
        // Create an instance of RemotePublisher
        RemotePublisher remotePublisher = new RemotePublisher();

        // Create registry and register remote publisher
        Registry registry = LocateRegistry.createRegistry(portNumber);
        registry.rebind(bindingName, remotePublisher);

        // Remote publisher registered
        System.out.println("Remote publisher registered.");
        System.out.println("Port number  : " + portNumber);
        System.out.println("Binding name : " + bindingName);

    }


}
