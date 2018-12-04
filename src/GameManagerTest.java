import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameManagerTest {

    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();

    ArrayList<Player> players = new ArrayList<Player>();

    @Test
    public void bubbleSortTest(){

        player1.setInitialDiceValue(12);
        player2.setInitialDiceValue(6);
        player3.setInitialDiceValue(10);

        players.add(player1);
        players.add(player2);
        players.add(player3);






    }


}
