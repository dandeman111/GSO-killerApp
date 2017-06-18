package Tests;

import Models.RuleSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by dande on 18-6-2017.
 */
class RuleSetTest {
    RuleSet testRuleset1;
    RuleSet testRuleset2;
    RuleSet testRuleset3;
    @BeforeEach
    void setUp() {
        testRuleset1 = new RuleSet(true,"testExtra1");
        testRuleset2 = new RuleSet(false,"testExtra 2");
        testRuleset3 = new RuleSet(true,"testExtra1");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFormat() {
        assert testRuleset1.getFormat();
        assertFalse(testRuleset2.getFormat());
    }

    @Test
    void setFormat() {
        testRuleset1.setFormat(false);
        assertFalse(testRuleset1.getFormat());
    }

    @Test
    void getExtra() {
        assertEquals("testExtra1",testRuleset1.getExtra());
    }

    @Test
    void setExtra() {
        testRuleset1.setExtra("test12");
        assertEquals("test12",testRuleset1.getExtra());
    }

    @Test
    void equals() {
        assert testRuleset1.equals(testRuleset3);
        assertFalse(testRuleset1.equals(testRuleset2));
    }

}