package Rmi.RmiRemoteServer;

import Models.Match;
import Models.User;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dande on 9-6-2017.
 */
public class RmiMatchFinder extends UnicastRemoteObject implements MatchFinder {
    private List<Match> matches;

    public RmiMatchFinder() throws RemoteException{
        matches = new ArrayList<>();

    }

    protected RmiMatchFinder(int port) throws RemoteException {
        super(port);
        matches = new ArrayList<>();
    }

    protected RmiMatchFinder(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
        matches = new ArrayList<>();
    }

    @Override
    public List<Match> getMatches() {
        return matches;

    }

    @Override
    public boolean joinMatch(Match match , User userSelf) {
        for (Match m : matches) {
            if(m.equals(match)&& m.joinedUser ==null&& m.hostUser!= match.hostUser){
                m.joinedUser = userSelf;
                return true;
            }
        }
        System.out.println(userSelf.toString() + "kan match: "+ match.toString()+ " niet joinen");
        return false;
    }

    @Override
    public boolean addMatch(Match match) {
        for (Match m : matches) {
            if(match.equals(m) && match.getId() != 0){ //checks if match already present
                System.out.println("Match zit al in de collectie");
                return false;
            }
        }
        matches.add(match);
        return true;
    }

    @Override
    public boolean removeMatch(Match match) {
        for (Match m : matches) {
            if(!match.equals(m)){ //checks if match is in collection
                System.out.println("Match zit niet in de collectie");
                return false;
            }else{
                matches.remove(match);
                return true;
            }
        }
        return false;
    }

    @Override
    public Match getMatch(int id) {
        for (Match m : matches) {
            if(m.getId() == id){
                return m;
            }
        }
        System.out.println("Match met id: "+ id + "is niet gevonden");
        return null;
    }


}
