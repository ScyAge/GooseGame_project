package goosegame.cell;
import goosegame.Player;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class TestWaitingCell {

    private Player p1;
    private Player p2;
    private WaitingCell c1;
    private Cell c2;

    @BeforeEach
    public void innit() {
        this.p1 = new Player("eric");
        this.p2 = new Player("ramzi");
        this.c1 = new WaitingCell(1,2);
        this.c2 = new Cell(2);

    }

    @Test
    public void TestThePlayerCantLeave(){
        this.c1.place_a_player(p1);
        assertFalse(c1.canLeave());
    }
    @Test
    public void TestThePlayerCanLeave(){
        this.c1.place_a_player(p1);
        assertFalse(c1.canLeave());
        assertFalse(c1.canLeave());
        assertTrue(c1.canLeave());
    }

    @Test
    public void ExchangePlayerResetCounter(){
        this.c1.place_a_player(p1);
        this.c2.place_a_player(p2);
        assertEquals(this.c1.getTourRestant(),2);
        this.c1.canLeave();
        assertEquals(this.c1.getTourRestant(),1);
        this.c1.place_a_player(p2);
        assertEquals(this.c1.getTourRestant(),2);
    }

}
