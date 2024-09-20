package goosegame.cell;

import goosegame.Player;
import goosegame.board.BordAbstract;
import goosegame.board.ClassicalBoard;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestTeleportingCell {

    private Player p1;
    private Player p2;

    private BordAbstract board;

    @BeforeEach
    public void innit() {
        this.p1 = new Player("eric");
        this.p2 = new Player("ramzi");
        this.board = new ClassicalBoard();

    }

    @Test
    public void theIndexWhereThePlayerNeedToBeTpIsGood(){
        //represent a teleporting cell
        Cell cell_58 = this.board.getCell(57);
        //represents the cell on which the player is teleporting
        Cell cell_1 = this.board.getCell(0);
        //the difference in distance between the cells, and therefore the number of cells the player has to cover to reach the cell he has to teleport to.
        int cell_to_move = this.board.getCell(57).rebond(10);

        assertEquals(this.board.getCell(0),this.board.getCell(57+cell_to_move));

    }


}
