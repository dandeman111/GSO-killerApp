package Database;

import Models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dande on 14-6-2017.
 */
public class MockDatabase implements IUserData {
    private List<User> users;

    public MockDatabase() {
        this.users = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            users.add(new User("gamertag"+i,"pwd"));
        }
    }

    @Override
    public User getUser(User user) {

        for (User u:users) {
            if(u.equals(user)){
                return u;
            }
        }
        return null;
    }
}
