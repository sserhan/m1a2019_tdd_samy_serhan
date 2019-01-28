import main.java.model.RPSEnum;
import main.java.model.Result;
import main.java.model.RockPaperScissors;
import org.testng.annotations.*;

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
    public void testWinPlay( String p1, String p2){
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.WIN);
    }

    @Parameters({"paper","paper"})
    @Test
    void testTiePlay(String p1,String p2){
        assertEquals(rps.play(RPSEnum.valueOf(p1),RPSEnum.valueOf(p2)), Result.TIE);
    }

    @Parameters({"rock","paper"})
    @Test
    void testLostPlay(String p1,String p2){
        assertEquals(rps.play(RPSEnum.valueOf(p1),RPSEnum.valueOf(p2)), Result.LOST);
    }
}