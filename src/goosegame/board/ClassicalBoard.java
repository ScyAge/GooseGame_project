package goosegame.board;

import goosegame.cell.*;

/**
 * class that creates a classic game board
 */
public class ClassicalBoard extends BordAbstract{

    /**
     * class constructor creates a 63-cell board
     */
    public ClassicalBoard(){
        super(63);

    }

    /**
     * the method that creates the classic goosegame board
     */
    protected void initBoard() {
        for(int i = 0; i<this.theCell.length;i++){
            //gooseCase
            if(i+1==9 || i+1==18 || i+1==27 || i+1==36 || i+1==45 ||i+1==54){
                this.theCell[i] = new GooseCell(i+1);
            }
            //trap Cell
            else if (i+1==31 ||i+1==52) {
                this.theCell[i] = new TrapCell(i+1);
            }
            // waiting Cell
            else if (i+1==19) {
                this.theCell[i] = new WaitingCell(i+1,2);
            }
            // Tp Cell pont
            else if (i+1==6) {
                this.theCell[i] = new TeleportingCell(12,i+1);
            }
            // Tp Cell labyrinthe
            else if (i+1==42) {
                this.theCell[i] = new TeleportingCell(30,i+1);
            }
            // Tp Cell tete de mort
            else if (i+1==58) {
                this.theCell[i] = new TeleportingCell(1,i+1);
            }
            //Normal Cell
            else {
                this.theCell[i] = new Cell(i+1);
            }
        }

    }


}
