package Rmi;

import Models.Match;
import Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;

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
        }
        return null;
    }
    public boolean addMatch(LocalDate date, User user, String title){
        try {
            matchFinder.addMatch(new Match(date,user,title));
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
}

