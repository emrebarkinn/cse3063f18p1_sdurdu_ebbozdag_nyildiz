import org.junit.Test;
import static org.junit.Assert.assertTrue;


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

}
