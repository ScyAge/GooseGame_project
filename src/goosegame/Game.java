package goosegame;

import goosegame.board.BordAbstract;
import goosegame.cell.*;

import java.util.ArrayList;
import java.util.List;

/**
 * class that controls goosegame
 */
public class Game {
    protected List<Player> thePlayer;
    protected BordAbstract board;

    /**
     *constructor for the class Game take one parameter
     * @param board the board where the player play
     */
    public Game(BordAbstract board) {
        this.board = board;
        this.thePlayer = new ArrayList<>();
    }

    /**
     * method that adds a player to the game
     * @param p a player
     */
    public void addPlayer(Player p) {
        thePlayer.add(p);
    }

    /**
     * method that returns true if no player has reached the end of the board
     * @return boolean
     */
    public boolean isGameFinished() {
        return this.board.getCell(this.board.getNbOfCells() - 1).getJoueur() == null;
    }

    /**
     * method for displaying game status at the end of a turn
     * @param p a player
     * @param case_init the inital cell where de player is
     * @param dice the value of the dice throw
     * @param temp_cell the temporary cell on which the player has passed
     * @param final_cell the final cell where it arrived
     */
    public void afficheEtat(Player p, int case_init,int dice,Cell temp_cell ,Cell final_cell) {

        if(temp_cell.rebond(dice)==0){
            System.out.println(p.getName() + " is in the cell " + case_init + ", "+p.getName()+" throws "+dice +" and reaches cell "+ final_cell.toString());
        }
        else{
            System.out.println(p.getName() + " is in the cell " + case_init + ", "+p.getName()+" throws "+dice +" and reaches cell "+ temp_cell.toString()+" and the player is sent to "+final_cell.toString());
        }





    }

    /**
     * method of moving a player on the board,
     * if the player goes beyond the end of the squares he is then brought back by the number of cells he has passed before the end cells.
     * @param p a player
     * @param case_theorique a theoretical cell which can be represented by the fact that the player is not in the cell but well above it.
     * @param dice the dice throw by the player
     * @return the case where the player need to go
     */
    public int movePlayerGame(Player p, int case_theorique, int dice) {

        if (case_theorique != 0) {
            if ((p.getCell().getNumber_of_the_cell() - 1 + dice + case_theorique) > (this.board.getNbOfCells() - 1)) {
                return (this.board.getNbOfCells() - 1) - ((p.getCell().getNumber_of_the_cell() - 1 + dice + case_theorique) - (this.board.getNbOfCells() - 1));
            } else {
                return p.getCell().getNumber_of_the_cell() - 1 + dice + case_theorique;
            }
        } else {
            if ((p.getCell().getNumber_of_the_cell() - 1 + dice) > (this.board.getNbOfCells() - 1)) {
                return (this.board.getNbOfCells() - 1) - ((p.getCell().getNumber_of_the_cell() - 1 + dice) - (this.board.getNbOfCells() - 1));
            } else {
                return p.getCell().getNumber_of_the_cell() - 1 + dice;
            }
        }
    }


    /**
     * method for starting a goosegame game
     */
    public void play() {
        int indice_joueur = 0;
        while (this.isGameFinished()) {

            //turn of a player
            Player joueur_du_tour = thePlayer.get(indice_joueur);
            int case_init = joueur_du_tour.getCell().getNumber_of_the_cell();

            //test if the player can play or if he is blocked on the cell
            if (joueur_du_tour.getCell().canLeave()) {

                //throwing dice
                int dice = joueur_du_tour.TwoDiceThrow();
                int premier_mouvement = this.movePlayerGame(joueur_du_tour, 0, dice);

                //we recover the first cell
                Cell nouvelle_case = this.board.getCell(premier_mouvement);

                //and we call its rebound
                int new_dice = nouvelle_case.rebond(dice);

                //to move or not our player once again depending on the nature of the cell.
                int deuxieme_mouvement = this.movePlayerGame(joueur_du_tour, dice, new_dice);
                Cell case_final = this.board.getCell(deuxieme_mouvement);

                //Finally, we place the player in the cell.
                case_final.place_a_player(joueur_du_tour);

                //and display the game status
                this.afficheEtat(joueur_du_tour, case_init,dice,nouvelle_case,case_final);

            }
            //player change for next round
            indice_joueur = (indice_joueur + 1) % thePlayer.size();
        }
    }
}
