package Tests;

import Models.Match;
import Models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by dande on 18-6-2017.
 */
class MatchTest {
    User testUser1;
    User testUser2;
    Match testmatch1;
    Match testmatch2;
    Match testMatch3;
    @BeforeEach
    void setUp() {
         testUser1 = new User("testGamertag1", "testPassword");
         testUser2 = new User("testGamertag2", "testPassword");
         testmatch1 = new Match(1,testUser1,"testTitle");
         testmatch2 = new Match(1,testUser1,"testTitle");
         testMatch3 = new Match(3,testUser2,"testTitle2");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void equals() {
        assert testmatch1.equals(testmatch2);
        assertFalse(testmatch1.equals(testMatch3));
    }

    @Test
    void getId() {
        assertEquals(1,testmatch1.getId());
    }


    @Test
    void getJoinedUser() {
        testmatch1.setJoinedUser(testUser2);
        assertEquals(testUser2,testmatch1.getJoinedUser());
    }

    @Test
    void setJoinedUser() {
        testmatch1.setJoinedUser(testUser2);
        assertEquals(testUser2,testmatch1.getJoinedUser());
    }

    @Test
    void getHostUser() {
        assertEquals(testUser1,testmatch1.getHostUser());
    }

}