package Tests;

import Models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by dande on 18-6-2017.
 */
class UserTest {
    User testUser1;
    User testUser2;
    User testUser3;
    @BeforeEach
    void setUp() {
        testUser1 = new User("testGamertag1", "testPassword");
        testUser2 = new User("testGamertag2", "testPassword");
        testUser3 = new User("testGamertag2", "testPassword");
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void equals() {
        assert testUser2.equals(testUser3);
        assertFalse(testUser1.equals(testUser3));
    }

}