package Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

/**
 * Created by dande on 9-6-2017.
 */
public class Match implements Serializable{
    private int id;
    private LocalDate date;
    private boolean hostWon;
    public User hostUser;
    public User joinedUser;
    public String title;
    public RuleSet finalRuleSet;

    public Match(LocalDate date, User hostUser,String title) {
        this.date = date;
        this.hostUser = hostUser;
        this.title = title;
        Random r = new Random();
        this.id  = r.nextInt(100000000);
    }

    public Match(int id, LocalDate date, User host) {
        this.id = id;
        this.date = date;
        this.hostUser = host;

    }

    public Match(int id, User hostUser, String title) {
        this.id = id;
        this.hostUser = hostUser;
        this.title = title;
    }

    public boolean equals(Match match){
        if(match.id == this.id){
            return true;
        }else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return title +" id: "+ Integer.toString(id);
    }

    public User getJoinedUser() {
        return joinedUser;
    }

    public void setJoinedUser(User joinedUser) {
        this.joinedUser = joinedUser;
    }

    public User getHostUser() {
        return hostUser;
    }
}
