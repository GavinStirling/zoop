import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User testUser;
    @BeforeEach
    public void init() {
        testUser = new User("Gavin");
    }

    @Test
    public void GetName_NameIsGavin_ReturnsName() {
        assertEquals("Gavin", testUser.getName());
        assertNotEquals("Rob", testUser.getName());
    }

    @Test
    public void GetScore_ScoreIsZero_ReturnsZero() {
        assertEquals(0, testUser.getScore());
        assertNotEquals(5, testUser.getScore());
    }

    @Test
    public void getTreatCount_TreatsAreFive_ReturnsFive() {
        assertEquals(5, testUser.getTreatCount());
        assertNotEquals(0, testUser.getTreatCount());
    }

    @Test
    public void DecrementTreats_RemovesOneTreat_ReturnsFour() {
        testUser.decrementTreats();
        assertEquals(4,testUser.getTreatCount());
    }

    @Test
    public void DecrementTreats_RemovesMultipleTreat_ReturnsZero () {
        testUser.decrementTreats();
        testUser.decrementTreats();
        testUser.decrementTreats();
        testUser.decrementTreats();
        testUser.decrementTreats();
        assertEquals(0, testUser.getTreatCount());
    }

    @Test
    public void HasTreatsLeft_HasTreats_ReturnsTrue() {
        assertTrue(testUser.hasTreatsLeft());
    }

    @Test
    public void HasTreatsLeft_HasTreats_ReturnsFalse() {
        testUser.setTreatCount(0);
        assertFalse(testUser.hasTreatsLeft());
    }

    @Test
    public void GetInfo_UserInfo_ReturnsCorrectInfo() {
        assertEquals(String.format("\nName : %s \nType : %s \nTreat Count : %s", testUser.getName(), testUser.getScore(), testUser.getTreatCount()), testUser.toString());
    }

    @Test
    public void IncrementScore_AddsTen_ReturnsTen() {
        testUser.incrementScore();
        assertEquals(10, testUser.getScore());
    }

    @Test
    public void IncrementScore_AddsMultiple_ReturnsOneHundred() {
        testUser.incrementScore();
        testUser.incrementScore();
        testUser.incrementScore();
        testUser.incrementScore();
        testUser.incrementScore();
        testUser.incrementScore();
        testUser.incrementScore();
        testUser.incrementScore();
        testUser.incrementScore();
        testUser.incrementScore();
        assertEquals(100, testUser.getScore());
    }

}