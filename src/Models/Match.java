package Models;

import java.util.Date;

/**
 * Created by Danny on 30-5-2017.
 */
public class Match {
    private int id;
    private Date plannedMatchDate;
    private boolean hostWon;

    public Match(int id, Date date) {
        this.id = id;
        this.plannedMatchDate = date;
    }


}
