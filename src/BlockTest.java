import org.junit.Test;
import static org.junit.Assert.*;

public class BlockTest {

    Block block = new Block();
    Player player=new Player("eee",100,10,true,null);
    Player owner = new Player();

    @Test
    public void purchaseBlockTest(){ //TODO : This method give null pointer exception

        player.setMoney(100);
        block.setPrice(50);
        block.setName("Test");
        block.purchaseBlock(player);

        assertEquals(50,player.getMoney(),0);
        assertEquals(player,block.getOwner());




    }

    @Test
    public void rentBlockTest(){

        player.setMoney(100);
        owner.setMoney(200);
        block.setOwner(owner);

        block.setRent(50);
        block.rentBlock(player);

        assertTrue(player.getMoney()==50);
        assertTrue(owner.getMoney()==250);


    }
}
