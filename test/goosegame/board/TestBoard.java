package goosegame.board;
import goosegame.cell.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class TestBoard {

    private ClassicalBoard board;

    @BeforeEach
    public void init(){
        this.board = new ClassicalBoard();

    }

    @Test
    public void initBoardOfClassicalBoard(){
        for(int i = 0 ; i < this.board.getNbOfCells();i++){
            if(i == 8||i == 17||i == 26||i == 35||i == 44||i == 53){
                assertTrue(this.board.getCell(i) instanceof GooseCell);
            } else if (i==30 ||i==51) {
                assertTrue(this.board.getCell(i) instanceof TrapCell);
            } else if (i==18) {
                assertTrue(this.board.getCell(i) instanceof WaitingCell);
            } else if (i==5||i==41||i==57) {
                assertTrue(this.board.getCell(i) instanceof TeleportingCell);
            }
            else{
                assertTrue(this.board.getCell(i) instanceof Cell);
            }
        }
    }
}
