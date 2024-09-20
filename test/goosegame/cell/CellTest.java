package goosegame.cell;


import goosegame.Player;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {
    private Player p1;
    private Player p2;
    private Cell c1;
    private Cell c2;

    @BeforeEach
    public void innit() {
        this.p1 = new Player("eric");
        this.p2 = new Player("ramzi");
        this.c1 = new Cell(1);
        this.c2 = new Cell(2);

    }

    @Test
    public void TestChangeCellIfPlayerAlreadyOnCell() {
        this.c1.place_a_player(p1);
        this.c2.place_a_player(p2);
        p1.setCell(c1);
        p2.setCell(c2);
        c2.place_a_player(p1);
        assertEquals(this.p1.getCell(), this.c2);
        assertEquals(this.p2.getCell(), this.c1);
        assertEquals(this.c1.getJoueur(), this.p2);
        assertEquals(this.c2.getJoueur(), this.p1);

    }

    @Test
    public void TestPlacePlayerNoPlayerInTheCell() {
        this.c1.place_a_player(p1);
        assertEquals(this.c1.getJoueur(), this.p1);
        assertEquals(this.p1.getCell(), this.c1);

    }

    @Test
    public void TestTheSamePlayerIsMooveToTheSameCell() {
        this.c1.place_a_player(p1);
        this.c1.place_a_player(p1);
        assertEquals(this.p1.getCell(), this.c1);
        assertEquals(this.c1.getJoueur(), this.p1);
    }

    @Test
    public void testIfplayerCanLeave(){
        this.c1.place_a_player(p1);
        assertTrue(this.p1.getCell().canLeave());
    }

    @Test
    public void TestRebond(){
        assertEquals(this.c1.rebond(5),0);
    }
}
