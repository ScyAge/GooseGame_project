package goosegame.cell;
import goosegame.Player;
import goosegame.cell.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestTrapCell {

    private Cell c1;
    private Player p1;


    @BeforeEach
    public void init(){
        this.c1 = new TrapCell(10);
        this.p1 = new Player("oui");
    }

    @Test
    public void TestPlayerCantPlay(){
        this.c1.place_a_player(p1);
        assertFalse(this.p1.getCell().canLeave());
    }





}
