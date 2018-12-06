import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameManagerTest {

    Player player1 = new Player("aaa",200,30,true,null);
    Player player2 = new Player("bbb",200,30,true,null);
    Player player3 = new Player("ccc",200,30,true,null);
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

    @Test
    public void bubbleSortPlayersWealthTest(){


        player1.addOwnedBlock(new Block(15,"aaa",200,0));
        player1.addOwnedBlock(new Block(17,"abc",150,0));
        player2.addOwnedBlock(new Block(10,"bbb",100,0));
        player2.addOwnedBlock(new Block(21,"bcd",200,0));
        player3.addOwnedBlock(new Block(5,"ccc",300,0));
        player3.addOwnedBlock(new Block(32,"cde",350,0));

        players.add(player1);
        players.add(player2);
        players.add(player3);

        gameManager.bubbleSortPlayersWealth(players);

        sortedPlayers.add(player3);
        sortedPlayers.add(player1);
        sortedPlayers.add(player2);

        assertEquals(players,sortedPlayers);
    }



}
