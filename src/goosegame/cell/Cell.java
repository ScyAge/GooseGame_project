package goosegame.cell;

import goosegame.Player;

/**
 * Class that describ what a cell is
 */
public class Cell {
    protected Player joueur;
    protected int number_of_the_cell;

    /**
     * constructor for the class cell take one parameter
     * @param number_of_the_cell represent the index of the cell
     */
    public Cell(int number_of_the_cell){
        this.number_of_the_cell = number_of_the_cell;
        this.joueur = null;

    }

    /**
     * method that return the player in the cell
     * @return joueur the player in the cell
     */
    public Player getJoueur() {
        return joueur;
    }

    /**
     * method that return the index of the cell
     * @return number_of_the_cell
     */
    public int getNumber_of_the_cell() {
        return number_of_the_cell;
    }

    /**
     * method that set a player into the cell
     * @param joueur a player
     */
    public void setJoueur(Player joueur) {
        this.joueur = joueur;
    }

    /**
     * method that say if a player can leave the cell
     * @return
     */
    public boolean canLeave(){
        return true;
    }

    /**
     * method which returns the number of extra cell the player must cover to reach his destination.
     * For example, if the method returns 0, this means that the player must stay on this cell.
     * @param dice is useless in this case
     * @return 0 an int
     */
    public int rebond(int dice){
        return 0;
    }

    /**
     * method for placing a player in a cell if the cell is already occupied then the player in the cell
     * and the new player swap places otherwise the player is just placed in the cell
     * @param p the new player
     */
    public void place_a_player(Player p){
        if(this.joueur != null){
            Player temp_player = this.getJoueur();
            this.setJoueur(p);
            p.getCell().setJoueur(temp_player);

            Cell temp_cell = this.getJoueur().getCell();
            this.getJoueur().setCell(temp_player.getCell());
            temp_player.setCell(temp_cell);
        }
        else{
            this.setJoueur(p);
            this.joueur.getCell().setJoueur(null);
            p.setCell(this);

        }
    }

    /**
     * method for displaying cell status
     * @return status
     */
    public String toString() {
        return getNumber_of_the_cell()+" ";
    }
}
