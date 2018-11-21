import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerTest {

    public double money;

    Player player = new Player();

    @Test
    public void decreaseMoneyTest(){

        double initialMoney = player.getMoney();
        player.decreaseMoney(money);
        assertTrue(initialMoney - money == player.getMoney());
    }
    @Test
    public void increaseMoneyTest(){

        double initialMoney = player.getMoney();
        player.increaseMoney(money);
        assertTrue(initialMoney + money== player.getMoney());
    }

    @Test
    public void isInJailTest(){

        boolean inJail=true;
        assertTrue(String.valueOf(player.isInJail()),inJail);

    }
    //TODO define assertEquals method arguments
   /* @Test
    public void sellOwnedBlockTest(){

        double prevMoney = player.getMoney();
        double salePrice=200;
        assertEquals(prevMoney+salePrice,player.sellOwnedBlock());
        }
    */

    }



