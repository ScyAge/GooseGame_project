package goosegame.cell;

import goosegame.Player;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class TestGooseCell {

    private Player p1;
    private Cell c1;

    @BeforeEach
    public void innit() {
        this.p1 = new Player("eric");
        this.c1 = new GooseCell(1);

    }

    @Test
    public void TestIfTheThrowDiceIsDoubled(){
        int dice = p1.TwoDiceThrow();
         int value_of_rebond = this.c1.rebond(dice);
         assertEquals(dice+value_of_rebond,2*dice);
    }
}
