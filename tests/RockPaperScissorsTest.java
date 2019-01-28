import main.java.model.Joueur;
import main.java.model.RPSEnum;
import main.java.model.Result;
import main.java.model.RockPaperScissors;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class RockPaperScissorsTest {

    private RockPaperScissors rps;
    private Joueur j1,j2;

    @DataProvider(name = "winData")
    public Object[][] createWinData() {
        return new Object[][] {
                { RPSEnum.ROCK , RPSEnum.SCISSORS},
                { RPSEnum.SCISSORS , RPSEnum.PAPER},
                { RPSEnum.PAPER , RPSEnum.ROCK}
        };
    }

    @DataProvider(name = "tieData")
    public Object[][] createTieData() {
        return new Object[][] {
                { RPSEnum.ROCK , RPSEnum.ROCK},
                { RPSEnum.SCISSORS , RPSEnum.SCISSORS},
                { RPSEnum.PAPER , RPSEnum.PAPER}
        };
    }

    @DataProvider(name = "lostData")
    public Object[][] createLostData() {
        return new Object[][] {
                { RPSEnum.ROCK , RPSEnum.PAPER},
                { RPSEnum.SCISSORS , RPSEnum.ROCK},
                { RPSEnum.PAPER , RPSEnum.SCISSORS}
        };
    }

    @org.testng.annotations.BeforeClass
    public void setUp() {
        rps = new RockPaperScissors();
        j1 = new Joueur("Samy");
        j2 = new Joueur("Zak");
    }

    @org.testng.annotations.AfterClass
    public void tearDown() {
        rps = null;
        j1=null;
        j2=null;
    }

    @Parameters({ "paper" ,"rock" })
    @Test
    public void testWinPlay(String p1,String p2){
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

    @Test ( dataProvider = "winData")
    void testWinPlay ( RPSEnum p1 , RPSEnum p2 ){
        assertEquals(rps.play(p1,p2),Result.WIN);
    }

    @Test ( dataProvider = "tieData")
    void testTiePlay ( RPSEnum p1 , RPSEnum p2 ){
        assertEquals(rps.play(p1,p2),Result.TIE);
    }

    @Test ( dataProvider = "lostData")
    void testLostPlay ( RPSEnum p1 , RPSEnum p2 ){
        assertEquals(rps.play(p1,p2),Result.LOST);
    }

    @Test
    void testWinPlay(){
        assertEquals(rps.play(j1,j2),Result.WIN);
    }

    @Test
    void testLostPlay(){
        assertEquals(rps.play(j1,j2),Result.LOST);
    }

    @Test
    void testTiePlay(){
        assertEquals(rps.play(j1,j2),Result.TIE);
    }

}