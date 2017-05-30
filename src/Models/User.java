package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danny on 30-5-2017.
 */
public class User {
    private String gamerTag;
    private String passWord;
    private List<Match> hostedMatches;
    private List<Match> joinedMatches;

    public User(String gamerTag, String passWord) {
        this.gamerTag = gamerTag;
        this.passWord = passWord;
        this.hostedMatches = new ArrayList<>();
        this.joinedMatches = new ArrayList<>();
    }

}
