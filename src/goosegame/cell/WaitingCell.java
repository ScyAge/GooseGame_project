package goosegame.cell;

import goosegame.Player;


/**
 * class WaitingCell that extend Cell describe how a  WaitingCell work , if you go on a WaitingCell you have to wait the number of turn specified to quit
 */
public class WaitingCell extends Cell {

    protected int tourRestant;
    protected final int tourRestantInit;

    /**
     * constructor for the class WaitingCell
     * @param number_of_the_cell index of the cell
     * @param tourRestant the number of turn the playerNeedToWait
     */
    public WaitingCell(int number_of_the_cell,int tourRestant) {
        super(number_of_the_cell);
        this.tourRestant = tourRestant;
        this.tourRestantInit = tourRestant;
    }

    /**
     * method that return the remaining turn to leave de cell
     * @return tourRestant
     */
    public int getTourRestant() {
        return tourRestant;
    }

    /**
     * method that return true only if the number of remaining turn  is equals to 0
     * @return boolean if a player can leave or not the cell
     */
    public boolean canLeave() {
        if (this.tourRestant == 0) {
            return true;
        } else {
            this.tourRestant--;
            return false;
        }

    }

    /**
     * methode place a player that work exactly like the one in Cell but when player exchange place the counter of remaining turn is reset
     * @param p the new player
     */
    public void place_a_player(Player p) {
        super.place_a_player(p);
        this.tourRestant = this.tourRestantInit;
    }

    @Override
    public String toString() {
        return super.toString()+" (waiting for "+getTourRestant()+" turns) ";
    }
}
