package Rmi;

import Models.Match;
import Rmi.RmiRemoteServer.MatchFinder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by dande on 14-6-2017.
 */
public class RmiController {
    private String ipAdress;
    private int portnumber;
    private String bindingName;
    private MatchFinder matchFinder;


    public RmiController(String ipAdress, int portnumber) {
        this.ipAdress = ipAdress;
        this.portnumber = portnumber;
        this.bindingName = "MatchFinder";
        this.matchFinder = getMatchFinder();
    }

    public MatchFinder getMatchFinder(){

        Registry r1;

            try {
                r1 = LocateRegistry.getRegistry(ipAdress,portnumber);
                return (MatchFinder) r1.lookup(bindingName);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {

                    e1.printStackTrace();
                }
            }




        return null;
    }
    public boolean addMatch(Match m){
        try {
            matchFinder.addMatch(m);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }
    public ObservableList<Match> getMatches(){
        try {
            return FXCollections.observableList(matchFinder.getMatches());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ObservableList<Match> getAvailableMatches(){
        ObservableList<Match> matches;
        try {
            matches = FXCollections.observableList(matchFinder.getMatches());

            for (Match m :matches) {
                if(m.joinedUser != null){
                    matches.remove(m);
                }
            }
            return matches;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;

    }
    public void removeMatch(Match match){
        try {
            matchFinder.removeMatch(match);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

