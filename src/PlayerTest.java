import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerTest {

    Player player ;
    public double money;

    @Before
    public void setUp(){
        player=new Player("eee",200,10,true,null);
        player.addOwnedBlock(new Block(15,"aaa",200,0));
    }

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
    @Test
    public void movePlayerTest(){

        player.setPosition(12);
        player.movePlayer(5);
        assertTrue(player.getPosition()==17);

    }
    @Test
    public void sellOwnedBlockTest(){



        player.sellOwnedBlock();
        assertEquals(player.getMoney(),400,0);

    }

}



