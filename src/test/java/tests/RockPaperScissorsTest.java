package tests;

import model.RPSEnum;
import model.Result;
import model.RockPaperScissors;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RockPaperScissorsTest {

    private RockPaperScissors rps;

    @org.testng.annotations.BeforeClass
    public void setUp() {
        rps = new RockPaperScissors();
    }

    @org.testng.annotations.AfterClass
    public void tearDown() {
        rps = null;
    }

    @Parameters({ "paper" ,"rock" })
    @Test
    public void testWinPlay(@Optional("paper") String p1,@Optional("rock") String p2){
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.WIN);
    }

    @Parameters({"paper","paper"})
    @Test
    void testTiePlay(@Optional("paper") String p1, @Optional("paper") String p2){
        assertEquals(rps.play(RPSEnum.valueOf(p1),RPSEnum.valueOf(p2)), Result.TIE);
    }

    @Parameters({"rock","paper"})
    @Test
    void testLostPlay(@Optional("rock") String p1, @Optional("paper") String p2){
        assertEquals(rps.play(RPSEnum.valueOf(p1),RPSEnum.valueOf(p2)), Result.LOST);
    }
}