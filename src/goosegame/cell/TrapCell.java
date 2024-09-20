package goosegame.cell;


/**
 * class TrapCell that extend Cell describe how a trap cell work nobody can escape a trap cell they need to swap place with another player
 */
public class TrapCell extends Cell{

    /**
     * constructor for the class TrapCell
     * @param number_of_the_cell index of the cell
     */
    public TrapCell(int number_of_the_cell){
        super(number_of_the_cell);
    }

    /**
     * method that say if a player can leave a trapCell
     * @return false
     */
    public boolean canLeave() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString()+" (trap) ";
    }
}
