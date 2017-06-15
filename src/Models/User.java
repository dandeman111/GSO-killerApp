package Models;

import java.io.Serializable;

/**
 * Created by dande on 9-6-2017.
 */
public class User implements Serializable {
    private String gamertag;
    private String password;

    public User(String gamertag, String password) {
        this.gamertag = gamertag;
        this.password = password;
    }

    public User(String gamertag) {
        this.gamertag = gamertag;
    }
    @Override
    public String toString(){
        return this.gamertag;
    }

    public boolean equals(User user){
        if(user.gamertag.equalsIgnoreCase(this.gamertag) && user.password.equalsIgnoreCase( this.password))return true;
        else return false;
    }
}
