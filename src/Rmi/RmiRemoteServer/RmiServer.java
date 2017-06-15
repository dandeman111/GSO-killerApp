package Rmi.RmiRemoteServer;

import Rmi.MatchFinder;
import Rmi.RmiMatchFinder;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by dande on 14-6-2017.
 */
public class RmiServer {
    private static MatchFinder matchFinder;
    private static Registry registry;

    private static final int portNumber = 1099;
    private static final String bindingName = "MatchFinder";


    public static void main(String[] args) {
        createRegistry(portNumber);

        try {
            matchFinder = new RmiMatchFinder();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        bindObject(matchFinder,bindingName);
    }

    private static void createRegistry(int port){
        try {
            registry = LocateRegistry.createRegistry(port);
            System.out.println("Registry is created at port: "+port);
        } catch (RemoteException e) {
            System.out.println("Could not create registry");
            e.printStackTrace();
        }
    }
    private static void bindObject(MatchFinder matchFinder,String bindName){
        try {
            registry.rebind(bindName,matchFinder);
            System.out.println( "MatchFinder was bound to the registry as: " + bindName);
        } catch (RemoteException e) {
            System.out.println("Could not bind: " + matchFinder.toString());
            e.printStackTrace();
        }
    }
}
