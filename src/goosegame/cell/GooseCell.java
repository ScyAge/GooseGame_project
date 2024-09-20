package goosegame.cell;


/**
 * class GooseCell that extend Cell describe how a  Goosecell work , if you go on a goosecell your throw dice is doubled
 */
public class GooseCell extends Cell{


    /**
     * constructor for the class GooseCell
     * @param number_of_the_cell index of the cell
     */
    public GooseCell(int number_of_the_cell){
        super(number_of_the_cell);
    }

    /**
     * method which returns the number of extra cell the player must cover to reach his destination.
     * For example, if the method returns 0, this means that the player must stay on this cell.
     * @param dice the value of the throw of dice
     * @return dice the value of the dice cause the player still needs to advance 6 cells
     */
    public int rebond(int dice) {
        return dice;
    }

    @Override
    public String toString() {
        return super.toString()+" (Goose) ";
    }
}
