package goosegame;

import goosegame.board.BordAbstract;
import goosegame.board.ClassicalBoard;

public class MainGame {

    public static void main(String[] args) {
        BordAbstract board = new ClassicalBoard();
        Game jeu = new Game(board);

        if(args.length == 0 ||args.length >4){
            Player j1 = new Player("simon");
            Player j2 = new Player("lamia");
            Player j3 = new Player("clara");
            jeu.addPlayer(j1);
            jeu.addPlayer(j2);
            jeu.addPlayer(j3);
        } else if (args.length== 2) {
            Player j1 = new Player(args[0]);
            Player j2 = new Player(args[1]);
            jeu.addPlayer(j1);
            jeu.addPlayer(j2);

        }else if (args.length== 3) {
            Player j1 = new Player(args[0]);
            Player j2 = new Player(args[1]);
            Player j3 = new Player(args[2]);
            jeu.addPlayer(j1);
            jeu.addPlayer(j2);
            jeu.addPlayer(j3);
        } else if (args.length== 4) {
            Player j1 = new Player(args[0]);
            Player j2 = new Player(args[1]);
            Player j3 = new Player(args[2]);
            Player j4 = new Player(args[4]);
            jeu.addPlayer(j1);
            jeu.addPlayer(j2);
            jeu.addPlayer(j3);
            jeu.addPlayer(j4);
        }
        jeu.play();

    }
}
