package Rmi.pushpull;

import fontyspublisher.IRemotePropertyListener;
import fontyspublisher.IRemotePublisherForDomain;
import fontyspublisher.IRemotePublisherForListener;

import java.beans.PropertyChangeEvent;
import java.rmi.NoSuchObjectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dande on 15-6-2017.
 */
public class RuleComunicator extends UnicastRemoteObject implements IRemotePropertyListener{

    //reference to ruleController
    private final RuleController ruleController;

    //remote publisher
    private IRemotePublisherForDomain publisherForDomain;
    private IRemotePublisherForListener publisherForListener;
    private static int portNumber = 1100;
    private static String bindingName = "RulesServer";
    private boolean connected = false;

    //thread pool
    private final int nrThreads = 10;
    private ExecutorService threadPool = null;

    public RuleComunicator( RuleController ruleController) throws RemoteException {
        this.ruleController = ruleController;
        threadPool = Executors.newFixedThreadPool(nrThreads);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) throws RemoteException {
        String property = evt.getPropertyName();
        RuleEvent ruleEvent = (RuleEvent) evt.getNewValue();
        ruleController.updateRules(property,ruleEvent);

    }
    public void connectToPublisher(){
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",portNumber);
            publisherForDomain = (IRemotePublisherForDomain) registry.lookup(bindingName);
            publisherForListener = (IRemotePublisherForListener) registry.lookup(bindingName);
            connected = true;
            System.out.println("Connection with remote publisher established");
        } catch (RemoteException e) {
            connected = false;
            System.err.println("Cannot establish connection to remote publisher");
            System.err.println("Run RulesServer to start remote publisher");
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public void register(String property){
        try {
            publisherForDomain.registerProperty(property);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public void subscribe(String property){
        if(connected){
            final IRemotePropertyListener listener = this;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        publisherForListener.subscribeRemoteListener(listener,property);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    public void unsubscribe(String property) {
        if (connected) {
            final IRemotePropertyListener listener = this;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        publisherForListener.unsubscribeRemoteListener(listener, property);
                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
    }
    public void broadcast(String property, RuleEvent ruleEvent) {
        if (connected) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        publisherForDomain.inform(property,null, ruleEvent);
                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
    }

    public void stop() {
        if (connected) {
            try {
                publisherForListener.unsubscribeRemoteListener(this, null);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
        try {
            UnicastRemoteObject.unexportObject(this, true);
        } catch (NoSuchObjectException ex) {
            ex.printStackTrace();
        }
    }



}
