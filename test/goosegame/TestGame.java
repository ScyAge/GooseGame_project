package goosegame;
import goosegame.board.ClassicalBoard;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class TestGame {

    private Game jeu;
    private Player j1;
    private Player j2;


    @BeforeEach
    public void init(){
        this.jeu = new Game(new ClassicalBoard());
        this.j1 = new Player("oliver");
        this.j2 = new Player("eric");

    }

    @Test
    public void testAddPlayer(){
        this.jeu.addPlayer(this.j1);
        assertTrue(this.jeu.thePlayer.contains(this.j1));
    }

    @Test
    public void GameFinishedTrue(){
        //we retrieve the last cell of the game and check that there is no player on it
        assertTrue(this.jeu.board.getCell(62).getJoueur() ==null);
    }
    @Test
    public void GameFinishedFalse(){
        //place a player on the last cell
        this.jeu.board.getCell(62).place_a_player(this.j1);
        //we check that the method returns false when there is a player on it
        assertFalse(this.jeu.board.getCell(62).getJoueur() == null);

    }

    @Test
    public void LancerDeDéDepuisUneCaseNormal(){
        int dice = 10;
        //on place le joueur sur la case 10;
        this.jeu.board.getCell(9).place_a_player(this.j1);
        //on applique le mouvement de 10 au joueur 1
        int case_final = this.jeu.movePlayerGame(this.j1,0,10);
        //si le joueur fait 10 depuis la case 10 il doit arriver sur la case 20 soit la case d'indice 19
        assertEquals(case_final,19);
    }

    @Test
    public void LancerDeDéDepuisUneCaseTemporaire(){
        int dice = 10;
        //on place le joueur sur la case 10;
        this.jeu.board.getCell(9).place_a_player(this.j1);
        //on applique le mouvement de 10 au joueur 1
        int case_temp = this.jeu.movePlayerGame(this.j1,0,10);
        //or il tombe sur une case qui lui demande d'aller 10 case plus loin soit la case 30 soit la case initial 10 plus le premier lancer 10 et les 10 suplémentaire
        int case_finale=this.jeu.movePlayerGame(this.j1,dice,10);
        assertEquals(case_finale,29);

    }

    @Test
    public void LancerDeDéDepuisUneCaseNormalMaisLaFinEstDepasser(){
        int dice = 10;
        //on place le joueur sur la case 60;
        this.jeu.board.getCell(59).place_a_player(this.j1);
        //on applique le mouvement de 10 au joueur 1
        int case_final = this.jeu.movePlayerGame(this.j1,0,10);

        //si le joueur fait 10 depuis la case 60 il doit arriver sur la case 63 mais il l'a depasse 7
        // il doit donc revenir de 7 case en arriere soit la case 56 celle d'indice 55
        assertEquals(case_final,55);
    }

    @Test
    public void LancerDeDéDepuisUneCaseTemporaireMaisLaFinEstDepasser(){
        int dice = 10;
        //on place le joueur sur la case 50;
        this.jeu.board.getCell(49).place_a_player(this.j1);
        //on applique le mouvement de 10 au joueur 1
        int case_temp = this.jeu.movePlayerGame(this.j1,0,10);
        //or il tombe sur une case qui lui demande d'aller 10 case plus loin soit la case 63 il mais il l'a depasse de 7  il doit reculer de 7 case soit la 56 d'indice 55
        int case_finale=this.jeu.movePlayerGame(this.j1,dice,10);
        assertEquals(case_finale,55);

    }

}
