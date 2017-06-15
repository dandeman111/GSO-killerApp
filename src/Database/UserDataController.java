package Database;

import Models.User;

/**
 * Created by dande on 14-6-2017.
 */
public class UserDataController {
    private IUserData userData;



    private User user;

    public UserDataController() {
        this.userData = new MockDatabase();
    }
    public boolean getUser(String gamertag,String password){
        this.user = userData.getUser(new User(gamertag,password));
        if(user!=null){
            return true;
        }
        return false;
    }
    public User getUser() {
        return user;
    }
}
