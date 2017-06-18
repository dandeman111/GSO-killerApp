package Rmi.RmiRemoteServer;

import Models.Match;
import Models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by dande on 9-6-2017.
 */
public interface MatchFinder extends Remote {
    List<Match> getMatches() throws RemoteException;
    boolean joinMatch(Match match, User userSelf)throws RemoteException;
    boolean addMatch(Match match)throws RemoteException;
    boolean removeMatch(Match match)throws RemoteException;
    Match getMatch(int id)throws RemoteException;
}