package goosegame.board;

import goosegame.Player;
import java.util.List;
import goosegame.cell.*;

/**
 * class that creates an abstract game board
 */
public abstract class  BordAbstract {
    protected final int nbOfCells;
    protected Cell[] theCell ;

    /**
     * constructor of the BoardAbstact class, it uses the abstaite initBoard method to create the game board you want, depending on how you inherit the class.
     * @param nbOfCells the number of the de board contain
     */
    public  BordAbstract(int nbOfCells){
        this.nbOfCells = nbOfCells;
        this.theCell = new Cell[this.nbOfCells];
        this.initBoard();
    }

    /**
     * returns the cell with the given index
     * @param indice indinx of the cell
     * @return the Cell
     */
    public Cell getCell(int indice){
        return this.theCell[indice];
    }

    /**
     * return the number of cell in the game
     * @return
     */
    public int getNbOfCells() {
        return this.nbOfCells;
    }

    /**
     * abstract method that initalizes the game board
     */
    protected abstract void initBoard();
}
