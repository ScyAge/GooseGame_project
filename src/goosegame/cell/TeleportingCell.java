package goosegame.cell;

/**
 * class TeleportingCell that extend Cell describe how a  TeleportingCell work , if you go on a TeleportingCell your are teleported on a another cell
 */
public class TeleportingCell extends Cell{
    protected int case_tp;

    /**
     * Constructor for the class TeleportingCell
     * @param case_TP the cell where you are teleported
     * @param number_of_the_cell the index of the Cell
     */
    public TeleportingCell(int case_TP,int number_of_the_cell){
        super(number_of_the_cell);
        this.case_tp = case_TP;

    }

    /**
     * method which returns the number of extra cell the player must cover to reach his destination.
     For example, if the method returns 0, this means that the player must stay on this cell.
     * @param dice is useless in this case
     * @return the difference in distance between the cells, and therefore the number of cells the player has to cover to reach the cell he has to teleport to.
     */
    public int rebond(int dice) {
        if(this.case_tp > this.number_of_the_cell){
            return this.case_tp-this.number_of_the_cell;
        }
        return -(this.number_of_the_cell-this.case_tp);
    }

    @Override
    public String toString() {
        return super.toString()+" (teleport to "+this.case_tp +") ";
    }
}
