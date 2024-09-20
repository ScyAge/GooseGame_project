package goosegame;
import goosegame.cell.Cell;
import java.util.Random;

/**
 * A player in the "jeu de l’oie " game
 */
public class Player {
    private static Random random = new Random();
    /**
     * Current cell of the player
     */
    protected Cell cell;
    /**
     * Name of the player
     */
    protected String name;

    /**
     * @param name the name of this player
     */
    public Player(String name) {

        this.name = name;
        this.cell = new Cell(0);
        this.cell.place_a_player(this);

    }

    /**
     * @see Object#toString ()
     */
    public String toString() {
        return this.name;
    }

    /**
     * @return the current cell of the player
     */
    public Cell getCell() {
        return this.cell;
    }

    /**
     * get the Name of the player
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * changes the cell of the player
     * @param newCell the new cell
     */
    public void setCell(Cell newCell) {
        this.cell = newCell;
    }

    /** @return random result of a 1d6 throw */
    private int oneDiceThrow(){
        return Player.random.nextInt(6)+1;
    }


    /** @return random result of a 2d6 throw */
    public int TwoDiceThrow(){
        int res = this.oneDiceThrow()+this.oneDiceThrow();
        return res;
    }



}
