import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameManagerTest {

    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();
    Die die1 = new Die();
    Die die2 = new Die();
    GameManager gameManager = new GameManager();

    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Player> sortedPlayers =new ArrayList<>();

    @Test
    public void bubbleSortTest(){

        player1.setInitialDiceValue(12);
        player2.setInitialDiceValue(6);
        player3.setInitialDiceValue(10);


        players.add(player1);
        players.add(player2);
        players.add(player3);


        gameManager.bubbleSortPlayers(players);

        sortedPlayers.add(player1);
        sortedPlayers.add(player3);
        sortedPlayers.add(player2);

        assertEquals(players,sortedPlayers);



    }
    @Test
    public void rollTurnDiceTest(){
        die1.setFace(3);
        die2.setFace(5);


        assertEquals(  gameManager.rollTurnDice(),8);

    }


}
