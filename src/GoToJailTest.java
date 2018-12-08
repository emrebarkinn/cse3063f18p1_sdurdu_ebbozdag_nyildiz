import org.junit.Test;

import static org.junit.Assert.*;


public class GoToJailTest {

    Player player = new Player();
    GoToJail goToJail = new GoToJail(30,player.getName());

    @Test
    public void playTurnTest(){

        player.setWaiting_time(0);
        player.setMoney(300);

        goToJail.playTurn(player);

        assertTrue(player.getWaiting_time()==3);
        assertTrue(player.getMoney()==200);

        player.setWaiting_time(0);
        player.setMoney(300);
        player.increaseJailCardCount();

        goToJail.playTurn(player);  //player will use jail free card

        assertTrue(player.getWaiting_time()==0);
        assertTrue(player.getMoney()==300);

        goToJail.playTurn(player);  //now player don't have jail free card. Player will get the penalty.

        assertTrue(player.getWaiting_time()==3);
        assertTrue(player.getMoney()==200);


    }
}
